package com.threadExample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzhaoyu
 * @date 2020/5/15 14:45
 */
public class ThreadDemoTest4 {

    public  static volatile boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (run) {
                // ....
            }
        });

        t.start();

        Thread.sleep(1);
        // 线程t不会如预想的停下来
        run = false;
    }

}