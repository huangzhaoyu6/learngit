package com.threadExample;

/**
 * @author huangzhaoyu
 * @date 2020/5/14 19:39
 */

public class ThreadDemoTest1 {

    /**
     * 使用两个线程先输出2再输出1
     */
    static final Object lock = new Object();
    //表示T2线程是否运行过
    static boolean t2Runned = false;


    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (lock){
                while (!t2Runned){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //执行T1逻辑
                System.out.println("1");
            }
        },"t1");

        Thread t2 = new Thread(()->{
            synchronized (lock){
                System.out.println(2);
                //执行T2逻辑
                t2Runned = true;
                lock.notify();
            }
        });

        t1.start();
        t2.start();


    }


}
