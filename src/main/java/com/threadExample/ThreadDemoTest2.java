package com.threadExample;

/**
 * @author huangzhaoyu
 * @date 2020/5/15 14:45
 */
public class ThreadDemoTest2 {

    /**
     *
     *  使用三个线程轮流输出abc，每个线程输出5次  abcabcabcabcabc
     *
     *  打印参数    当前线程     下一个需要执行的线程
     *     a            1                 2
     *     b            2                 3
     *     c            3                 1
     *
     *  如果不等于当前变量，使用wait方法让当前线程进入等待状态
     *  如果等于当前变量，输出值，然后唤醒其他两个线程
     *  这个时候，其他两个线程进入就绪状态  如果对的线程进入运行状态，则打印->然后继续从头开始
     *  如果错误的线程进入了运行状态，则直接进入等待状态，继续让其他两个
     **/

    public static class PrintObj{
        //当前类的等待标记
        public int flag;
        //当前类的循环次数
        public int loopNumber;

        public PrintObj(int flag, int loopNumber) {
            this.flag = flag;
            this.loopNumber = loopNumber;
        }

        public void print(String printStr, Integer nowFlag, Integer nextFlag){
            for (int i = 0; i < loopNumber; i++) {
                synchronized (this){
                    while (flag != nowFlag){
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(printStr);
                    this.notifyAll();
                    flag = nextFlag;
                }
            }
        }

    }



    public static void main(String[] args) {
        PrintObj obj = new PrintObj(1,5);
        new Thread(()->{obj.print("a",1,2);},"T1").start();
        new Thread(()->{obj.print("b",2,3);},"T2").start();
        new Thread(()->{obj.print("c",3,1);},"T3").start();

    }

}
