package com.threadExample;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzhaoyu
 * @date 2020/5/6 15:42
 */
@Slf4j(topic = "c.Thread_02")
public class Thread_02 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition waitCigaretteQueue = lock.newCondition();
    static Condition waitbreakfastQueue = lock.newCondition();
    static volatile boolean hasCigrette = false;
    static volatile boolean hasBreakfast = false;


    public static void main(String[] args) {
        //线程小明等烟
        new Thread(() -> {
            try {
                //加锁
                lock.lock();
                while (!hasCigrette) {
                    try {
                        waitCigaretteQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("等到了他的烟");
            } finally {
                //释放锁
                lock.unlock();
            }
        }, "小明").start();

        //线程小南等饭
        new Thread(() -> {
            try {
                //加锁
                lock.lock();
                while (!hasBreakfast) {
                    try {
                        waitbreakfastQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("等到了他的零食");
            } finally {
                //释放锁
                lock.unlock();
            }
        }, "小南").start();


        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendBreakfast();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendCigarette();


    }

    private static void sendBreakfast() {
        try {
            lock.lock();
            try {
                hasBreakfast = true;
                waitbreakfastQueue.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.debug("饭送到了");
        } finally {
            lock.unlock();
        }
    }

    private static void sendCigarette() {
        try {
            lock.lock();
            try {
                hasCigrette = true;
                waitCigaretteQueue.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.debug("烟送到了");
        } finally {
            lock.unlock();
        }
    }

}
