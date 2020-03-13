package com.arithmetic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author huangzhaoyu
 * @date 2020/3/11 12:58
 */
public class Demo_32 {

    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     * 示例 1:
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     * <p>
     * 示例 2:
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     */

    /**
     *
     *  解题思路：
     *
     * 1.需有一个变量start记录有效括号子串的起始下标，max表示最长有效括号子串长度，初始值均为0
     *
     * 2.遍历给字符串中的所有字符
     *
     *     2.1若当前字符s[index]为左括号'('，将当前字符下标index入栈（下标稍后有其他用处），处理下一字符
     *
     *     2.2若当前字符s[index]为右括号')'，判断当前栈是否为空
     *
     *         2.2.1若栈为空，则start = index + 1，处理下一字符（当前字符右括号下标不入栈）
     *
     *         2.2.2若栈不为空，则出栈（由于仅左括号入栈，则出栈元素对应的字符一定为左括号，可与当前字符右括号配对），判断栈是否为空
     *
     *             2.2.2.1若栈为空，则max = max(max, index-start+1)
     *
     *             2.2.2.2若栈不为空，则max = max(max, index-栈顶元素值)
     *
     */

    public int longestValidParentheses(String s) {
        //max表示最长有效括号子串长度
        int max = 0;
        //start记录有效括号子串的起始下标
        int start = 0;
        if(null == s){
            return 0;
        }
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        for(int index = 0; index < len; index++){
            //遇左括号(，压栈(栈中元素为当前位置所处的下标)
            if('(' == s.charAt(index)){
                stack.push(index);
                continue;
            } else {
                if(stack.isEmpty()){
                    //记录有效括号子串的起始下标
                    start = index+1;
                    continue;
                } else {
                    stack.pop();
                    if(stack.isEmpty()){
                        //证明左括号已全部清空，左侧只能有右括号，所以需要减掉右括号的下标。
                        max = Math.max(max, index-start+1);
                    } else {
                        max = Math.max(max, index-stack.peek());
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Demo_32().longestValidParentheses("(((()"));
    }


}
