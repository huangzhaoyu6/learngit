package com.threadExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author huangzhaoyu
 * @date 2019/12/30 14:49
 */
public class TestCachedThreadPool {

    /**
     * submit和excute的区别
     */
    public static void main(String[] args) {
        ExecutorService executorService = ThreadPoolUtils.getInstance();
//        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 5; i++) {
            int a = i;
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
//            Future<Integer> submit = executorService.submit(() -> submitRun(a));
            executorService.execute(() -> executeRun(a));
            //将任务执行结果存储到List中
//            resultList.add(submit);
        }
        /*for (Future<Integer> fs : resultList) {
            try {
                System.out.println(fs.get());     //打印各个线程（任务）执行的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
                executorService.shutdown();
            }
        }*/
    }


    public static int submitRun(int i)throws Exception {
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
        if(i==2){
            throw new Exception("主动抛出异常");
        }
        return i;
    }

    public static int executeRun(int i){
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
        if(i==2){
            int o = 2/0;
        }
        return i;
    }
}
