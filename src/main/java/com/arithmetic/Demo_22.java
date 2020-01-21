package com.arithmetic;

import java.util.*;

/**
 * @author huangzhaoyu
 * @date 2020/1/20 9:19
 */
public class Demo_22 {

    /**
     *
     *  给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * 例如，给出 n = 3，生成结果为：
     *
     * [
     *   "(((  )))",
     *   "(()  ())",
     *   "(()  )()",
     *   "()(  ())",
     *   "()(  )()"
     * ]
     *
     */


    /**
     * n = 3
     * f(3): [()()(),  (())(),  ()(())]
     * f(i-1): [()(),  (())]
     * f(1): [()]
     *
     * 思路：由上述示例可得出
     * f(i) = 将f(1)插入到f(i-1)的每一个结果中的每一个位置中，
     * 然后去重就可以了
     */

    public List<String> generateParenthesis(int n) {
        Set<String> result = new TreeSet<>();
        //设置递归基
        if (n == 0) {
            return new ArrayList<>(result);
        }
        if (n == 1) {
            result.add("()");
            return new ArrayList<>(result);
        }
        //n肯定大于1 所以初始化f(1) = [()]
        result.add("()");
        //开始递归求解
        while (n != 1) {
            Set<String> nowres = new TreeSet<>();
            Iterator<String> iterator = result.iterator();
            while (iterator.hasNext()) {
                String nextStr = iterator.next();
                for (int i = 0; i < nextStr.length(); i++) {
                    nowres.add(nextStr.substring(0, i) + "()" + nextStr.substring(i));
                }
            }
            result = nowres;
            n--;
        }
        return new ArrayList<>(result);
    }

    /**
     *  如果我们发现(的数量小于n的话，
     *  我们就填入(
     *  如果我们发现)的数量小于(的话，
     *  我们就填入)
     *
     *
     */


    public static void main(String[] args) {
        System.out.println(new Demo_22().generateParenthesis(4));
    }


}
