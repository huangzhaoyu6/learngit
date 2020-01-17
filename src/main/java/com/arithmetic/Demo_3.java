package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/11/9
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Demo_3 {

    /**
     *
     *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     */


    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring0(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                //每次循环i到j中间的所有元素中是否包含重复值i
                //如果不包含重复值，则将max的值重新设定
                if(getRepetion(i,j,s)) ans = Math.max(ans,j-i);
            }
        }
        return ans;
    }

    public static boolean getRepetion(int i,int j,String s){
        HashSet set = new HashSet();
        for (int st  = i; st < j; st++) {
            if(set.contains(s.charAt(st))){
                return false;
            }
            set.add(s.charAt(st));
        }
        return  true;
    }

    public static int lengthOfLongestSubstring3(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);  //设置队列的第一个元素为开始位置的下一个值
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1); //设置最大值为第一个元素到当前元素到的长度

        }
        return max;

    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("abcabcedbb"));
    }

}
