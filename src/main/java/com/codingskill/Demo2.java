package com.codingskill;

/**
 * @author huangzhaoyu
 * @date 2020/1/7 16:00
 */
public class Demo2 {

    long var;
    public void Demo2(long param){
        var = param;
    }

    public Demo2(long var) {
        this.var = var;
    }

    public Demo2() {
        this.var = var;
    }

    public static void main(String[] args) {
        Demo2 a,b;
        a = new Demo2();
        b = new Demo2(5L);
    }

}
