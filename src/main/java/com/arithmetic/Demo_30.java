package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/2/13
*/

import java.util.*;

public class Demo_30 {
    int strLength;
    int length;
    /**
     *
     */

    public List<Integer> findSubstring(String s, String[] words) {
        length = words.length;
        List<Integer> list = new ArrayList<>();
        if(length == 0){
            return list;
        }
        strLength = words[0].length();
        int sumLength = length * strLength;
        if(sumLength > s.length()){
            return list;
        }
        //判断i-j字符串分割为三段后是否包含所有的words
        for (int i = 0; i <= s.length() - sumLength; i++) {
            if(isChildStr(i,i + sumLength,s,words)) list.add(i);
        }
        return list;
    }

    public  boolean isChildStr(int i,int j,String s, String[] words){
        List<String> list = new ArrayList<>();
        for (int k = i; k < j; k += strLength) {
            list.add(s.substring(k,k + strLength));
        }
        //判断list中是否包含了所有的words的值
        for (int k = 0; k < length; k++) {
            for (int l = 0; l < list.size(); l++) {
                if(list.get(l).equals(words[k])){
                    list.remove(l);
                    break;
                }
            }
        }
        if(list.size()==0){
            return  true;
        }
        return  false;
    }

    //通过哈希表的相同的key存储在通过hash计算生成的位置一样，比较两个map是否一样
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;   
    }



    public static void main(String[] args) {

        String str = "aaaaaaaaa";
        String[] arr = {"aa","aa"};
        List<Integer> substring = new Demo_30().findSubstring(str, arr);
        System.out.println(substring);
    }

}
