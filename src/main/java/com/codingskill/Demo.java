package com.codingskill;

/**
 * @author huangzhaoyu
 * @date 2020/1/7 15:47
 */
public class Demo {

    String str = new String("aaa");
    char[] ch = {'a','b'};

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.chang(demo.str,demo.ch);
        System.out.println(demo.str+"and");
        System.out.println(demo.ch);
    }

    public void chang(String str ,char[] ch){
        str = "ok";
        ch[0] = 'c';
    }
}
