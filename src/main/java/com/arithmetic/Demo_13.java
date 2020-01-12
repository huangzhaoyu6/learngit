package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/1/12
*/

import java.util.HashMap;
import java.util.Map;

public class Demo_13 {

    /**
     *
     *
     */
    public static int intToRoman2(String s) {
        Map<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);

        int answer = 0;
        int size = s.length();
        for(int i=0;i<size;){
            int tempStep = 1;
            System.out.println("i="+i);
            if( i + 1 < size && map.containsKey(s.substring(i,i+2))){
                tempStep = 2;
            }

            String tempValue = s.substring(i,(i+tempStep));
            System.out.println("tempValue="+tempValue);
            answer += map.get(tempValue);
            i+=tempStep;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman2("III"));
    }

}
