package com.threadExample;

import org.apache.tomcat.util.threads.TaskQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@FunctionalInterface
interface RejectPolicy<T> {
    void reject(MyThreadPool.BlockingQueue<T> queue, T task);
}

/**
 * @author huangzhaoyu
 * 自定义线程池的实现
 * @date 2020/12/3 16:15
 */
public class MyThreadPool {

        //线程存放集合
        private HashSet<Woker> wokers = new HashSet();

        //阻塞队列
        private BlockingQueue<Runnable> blockingQueue;

        //核心线程数
        private int coreSize;

        //超时时间
        private long timeout;

        //超时时间的单位
        private TimeUnit timeUnit;

        //拒绝策略
        private RejectPolicy rejectPolicy;

        //线程类
        class Woker extends Thread{
            private Runnable task;

            public Woker(Runnable task) {
                this.task = task;
            }

            @Override
            public void run() {
                //1.当task不为空，执行任务
                //2.当task为空，从任务队列中取出来任务继续执行
//                while (task!=null || (task = blockingQueue.take())!=null){   //这种是死等
                while (task!=null || (task = blockingQueue.poll(timeout,timeUnit))!=null){  //这种带超时时间的等待
                    try {
                        task.run();
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        task = null;
                    }
                }
                //没有任务，销毁线程
                synchronized (wokers){
                    System.out.println("woker被移除");
                    wokers.remove(this);
                }

            }
        }

        public MyThreadPool(int queueCapcity ,int coreSize, long timeout, TimeUnit timeUnit,RejectPolicy rejectPolicy) {
            this.blockingQueue = new BlockingQueue(queueCapcity);
            this.coreSize = coreSize;
            this.timeout = timeout;
            this.timeUnit = timeUnit;
            this.rejectPolicy = rejectPolicy;
        }

        /**
         * 执行任务
         */
        public void execute(Runnable task){
            //下面的woker.size和wokers.add不是线程安全的
            synchronized (wokers) {
                //当任务数量小于核心线程数时，交给woker对象执行
                if(wokers.size()<coreSize){
                    Woker woker = new Woker(task);
                    System.out.println("新增任务");
                    wokers.add(woker);
                    woker.start();
                }else{
                    //否则丢到队列中等待
                    System.out.println("将任务丢到队列中");
//                    blockingQueue.put(task);  //阻塞式的丢任务
                    if(!blockingQueue.put2(task)){//非阻塞式的丢任务
                        //丢队列失败的话，本来应该创建急救线程，这里省略了
                        //丢急救线程失败了，执行拒绝策略
                        rejectPolicy.reject(blockingQueue,task);
                    }
                }
            }
        }


    /**
     * 阻塞队列的实现
     * @param <T>
     */
    class BlockingQueue<T>{

        //任务队列
        private Deque<T> queue = new ArrayDeque<>();

        //锁
        ReentrantLock lock = new ReentrantLock();

        //保护队列头的线程安全，生产者条件变量
        private Condition fullWaitSet = lock.newCondition();

        //保护队列尾部的线程安全，消费者条件变量
        private Condition emptyWaitSet = lock.newCondition();

        //队列的容量
        private int capcity;

        public BlockingQueue(int capcity) {
            this.capcity = capcity;
        }

        //添加元素  阻塞式的
        public void put(T t){
            //先加锁
            lock.lock();
            try {
                //判断队列是否已满，满了需要等待
                while (queue.size() == capcity){
                    try {
                        //----->生产者线程会阻塞到这一行，并且处于waitSet等待队列中
                        fullWaitSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //不满，放入队列尾部
                queue.addLast(t);
                //唤醒消费者队列中的线程，让它继续往下执行
                emptyWaitSet.signal();
            }finally {
                lock.unlock();
            }
        }

        //添加元素  不阻塞式的 满了直接返回false
        public boolean put2(T t){
            //先加锁
            lock.lock();
            try {
                //判断队列是否已满，满了需要等待
                if(queue.size() == capcity){
                    return false;
                }else{
                    //不满，放入队列尾部
                    queue.addLast(t);
                    //唤醒消费者队列中的线程，让它继续往下执行
                    emptyWaitSet.signal();
                    return true;
                }
            }finally {
                lock.unlock();
            }
        }

        //获取元素
        public T take(){
            //先加锁
            lock.lock();
            try {
                //判断是否为空，为空需要让线程进行等待
                while(queue.isEmpty()){
                    try {
                        //----->消费者线程会阻塞到这一行，并且处于waitSet等待队列中
                        emptyWaitSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //不为空，首个元素出队列
                T t = queue.removeFirst();
                //唤醒生产者队列中的线程，让它继续往下执行
                emptyWaitSet.signal();
                return t;
            }finally {
                lock.unlock();
            }
        }

        //获取元素 带超时
        public T poll(long timeout, TimeUnit timeUnit){
            //时间转换为纳秒
            long nanos = timeUnit.toNanos(timeout);
            //先加锁
            lock.lock();
            try {
                //判断是否为空，为空需要让线程进行等待
                while(queue.isEmpty()){
                    try {
                        //为了以防本次线程没等够，被虚假唤醒了，又要等待nanos秒
                        if(nanos<0){
                            return null;
                        }
                        //awaitNanos的返回值为设定的等待时间-本次等待的时间，所以只需要等待这个剩余时间就可以
                        //----->消费者线程会阻塞到这一行，并且处于waitSet等待队列中
                        nanos = emptyWaitSet.awaitNanos(nanos);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //不为空，首个元素出队列
                T t = queue.removeFirst();
                //唤醒生产者队列中的线程，让它继续往下执行
                emptyWaitSet.signal();
                return t;
            }finally {
                lock.unlock();
            }
        }

        //获取队列大小
        public int size(){
            lock.lock();
            try {
                return queue.size();
            }finally {
                lock.unlock();
            }
        }

    }

}
