package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/2/2
*/

public class Demo_28 {

    /**
     *
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     *
     * 说明:
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
     * 这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     */

    /**
     * 在母字符串中寻找 子字符串中的第一个字符 m
     * 找到后如果m后面的字符与子字符串m后面的字符相等
     * 返回母串中m的下标
     * 如果不等，取下一个m
     */
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        char n = needle.charAt(0);
        int hlength = haystack.length();
        for (int i = 0; i < hlength; i++) {
            while (i < hlength && haystack.charAt(i) != n) {
                i++;
            }
            int nlength = needle.length();
            if (nlength == 1 && i != hlength){
                return i;
            }
            //当母串m后面的字符串的长度小于n后面的子串时，跳出循环
            int hi = i + 1;
            int j = 1;
            //找到后如果m后面的字符与子字符串m后面的字符依次比较
            while (hlength - i - 1 >= needle.length() - 1 && nlength > 1) {
                if (haystack.charAt(hi) == needle.charAt(j)) {
                    hi++;
                    j++;
                    nlength--;
                    if (nlength == 1) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Demo_28().strStr("12363303363", "9"));
    }

}
