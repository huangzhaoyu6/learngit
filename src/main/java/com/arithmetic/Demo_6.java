package com.arithmetic;

import java.rmi.dgc.Lease;
import java.util.jar.JarEntry;

/**
 * @author huangzhaoyu
 * @date 2019/11/19 14:08
 */
public class Demo_6 {

/*
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

    比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

    L   C   I   R
    E T O E S I I G
    E   D   H   N

    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

    请你实现这个将字符串进行指定行数变换的函数：

    string convert(string s, int numRows);

    示例 1:

    输入: s = "LEETCODEISHIRING", numRows = 3
    输出: "LCIRETOESIIGEDHN"

    示例 2:

    输入: s = "LEETCODEISHIRING", numRows = 4
    输出: "LDREOEIIECIHNTSG"
    解释:

    L     D     R
    E   O E   I I
    E C   I H   N
    T     S     G
*/

    public static String convert(String s, int numRows) {
        //将该字符串存入一个二维数组
        int length = s.length();
        int index = 0;
        int x = numRows;
        int y = length % numRows == 0 ? length / numRows : length / numRows + 1;
        char[][] charArr = new char[x][y];
        for (int i = 0; i < y; i++) {
            if (i % (numRows - 1) == 0) {
                //给那一竖赋值
                for (int j = 0; j < x; j++) {
                    charArr[i][j] = s.charAt(index);
                    index++;
                }
            }

        }
        System.out.println(charArr);

        return null;
    }

    public static void main(String[] args) {
        convert("abcdefqabcdefq", 3);
    }

}
