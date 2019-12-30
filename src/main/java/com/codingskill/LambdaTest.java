package com.codingskill;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author huangzhaoyu
 * @date 2019/12/28 17:48
 */
public class LambdaTest {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("普通，线程启动");
            }
        };
//        runnable.run();
//        test1();
//        test2();
//        test3();
//        使用lambda表达式对集合进行迭代
      /*  List<String> list = Arrays.asList("java","c#","javascript");
        //before java8
        for (String str:list){
            System.out.println("before java8,"+str);
        }
        //after java8
        list.forEach(x-> System.out.println("after java8,"+x));*/

//        用lambda表达式  map  将一个对象转换为另一个
//        List<Double> list = Arrays.asList(10.0,20.0,30.0);
//        list.stream().map(x->x*1.05).forEach(x-> System.out.println(x));

//        reduce实现的则是将所有值合并为一个
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        double sum = 0;
        for(double each:cost) {
            each += each * 0.05;
            sum += each;
        }
        System.out.println("before java8,"+sum);
        //after java8
        List<Double> list = Arrays.asList(10.0,20.0,30.0);
        double sum2 = list.stream().map(x->x+x*0.05).reduce((sum1,x)->sum1+x).get();
        System.out.println("after java8,"+sum2);



    }

    public static void test1(){
        Runnable runnable = ()-> System.out.println("lambda表达式启动线程");
        runnable.run();
    }

    public static void test2() {
        //这个e就代表所实现的接口的方法的参数，
        Consumer<String> consumer = e->System.out.println("Lambda 表达式方式，"+e);
        consumer.accept("传入参数");
    }

    public static void test3(){
        Comparator<Integer> com = (x,y)->{
            System.out.println("函数接口");
            return Integer.compare(x,y);
        };
        int compare = com.compare(100,200);
        System.out.println("有两个以上的参数，有返回值,"+compare);
    }

    public static void test9(){
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
        Comparator<Integer> comparator1 = Integer::compare;
        int compare = comparator.compare(1,2);
        int compare1 = comparator1.compare(1,2);
        System.out.println("compare:"+compare);
        System.out.println("compare1:"+compare1);
    }



}
