package com.threadExample;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具类
 *
 * @author
 */
public class ThreadPoolUtils {
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolUtils.class);
    /**
     * 线程池中线程数量
     */
    private static String threadNumber = "5";

    static {
        Properties props = new Properties();
        try {
            props.load(ThreadPoolUtils.class.getResourceAsStream("/system.properties"));
            threadNumber = props.getProperty("thread.pool.number");
        } catch (Exception e) {
            logger.info("初始化线程池配置出错");
        }
    }

    private ThreadPoolUtils() {

    }

    public static ExecutorService getInstance() {
        return Executor.INSTANCE.getInstance();
    }

    /**
     * Executor
     */
    private enum Executor {
        /**
         * INSTANCE
         */
        INSTANCE;
        /**
         * ExecutorService
         */
        private ExecutorService executor;

        Executor() {
            executor = new ThreadPoolExecutor(Integer.parseInt(threadNumber), 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024),
                    new ThreadFactoryBuilder().setNameFormat("common-thread-%d").build(), new ThreadPoolExecutor.AbortPolicy());
        }

        public ExecutorService getInstance() {
            return executor;
        }
    }
}
