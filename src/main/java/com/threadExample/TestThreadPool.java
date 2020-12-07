package com.threadExample;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestThreadPool")
public class TestThreadPool {
    public static void main(String[] args) throws InterruptedException {

//        MyThreadPool.ThreadPool threadPool = new MyThreadPool.ThreadPool(1, 1000, TimeUnit.MILLISECONDS, 1,
//                (queue, task) -> {
//                    task.run();
//                });

        MyThreadPool threadPool = new MyThreadPool(2, 2,1000,TimeUnit.MILLISECONDS,
                    (queue,task)->{

                    }
                );
        for (int i = 0; i < 3; i++) {
            int j = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("{}","任务被执行----> "+ j);
            });
        }
    }


}
