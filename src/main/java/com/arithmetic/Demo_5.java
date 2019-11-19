package com.arithmetic;

import java.util.HashMap;

/**
 * @author huangzhaoyu
 * @date 2019/11/11 14:01
 */
public class Demo_5 {

    /*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

    示例 1：

    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。

    示例 2：

    输入: "cbbd"
    输出: "bb"
    */

    public static String lengthOfLongestSubstring3(String s) {
        int n = s.length();
        String str = "";
        if (n < 2) return s;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                //查看是否为回文
                if (isAnnular(s, i, j)) {
                    String substring = s.substring(i, j+1);
                    str = substring.length() > str.length() ? substring : str;
                }
            }
        }
        return str;
    }

    public static boolean isAnnular(String s, int left, int right) {
        int length = right - left;
        if (length == 1) {
            return true;
        }
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        return maxPal;
    }

    //别人的暴力解法
    public static String longestPalindrome4(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        String res = s.substring(0, 1);

        // 枚举所有长度大于等于 2 的子串
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && valid(s, i, j)) {
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private static boolean valid(String s, int left, int right) {
        // 验证子串 s[left, right] 是否为回文串
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring3("cbbd"));
        System.out.println("abaae".substring(0,4));
    }

}
