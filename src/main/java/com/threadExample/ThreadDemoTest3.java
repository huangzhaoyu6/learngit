package com.threadExample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzhaoyu
 * @date 2020/5/15 14:45
 */
public class ThreadDemoTest3 {

    /**
     *
     *  使用三个线程轮流输出abc，每个线程输出5次  abcabcabcabcabc
     *
     *  打印参数    当前线程     下一个需要执行的线程
     *     a            1                 2
     *     b            2                 3
     *     c            3                 1
     *
     *
     **/

    public static class PrintObj extends ReentrantLock {
        //当前类的循环次数
        public int loopNumber;

        public PrintObj(int loopNumber) {
            this.loopNumber = loopNumber;
        }

        //  打印的内容  进入的休息室   下一间休息室
        public void print(String printStr, Condition nowCondition, Condition nextCondition){
            for (int i = 0; i < loopNumber; i++) {
                this.lock();
                try {
                    //当前休息室等待
                    nowCondition.await();
                    System.out.println(printStr);
                    //释放当前休息室的等待
                    nextCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    this.unlock();
                }
            }
        }
    }



    public static void main(String[] args) {
        PrintObj obj = new PrintObj(5);
        Condition a = obj.newCondition();
        Condition b = obj.newCondition();
        Condition c = obj.newCondition();
        new Thread(()->{obj.print("a",a,b);},"T1").start();
        new Thread(()->{obj.print("b",b,c);},"T2").start();
        new Thread(()->{obj.print("c",c,a);},"T3").start();
        //等待一秒  唤醒a休息室的线程
        obj.lock();
        try {
            a.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            obj.unlock();
        }

    }

}
