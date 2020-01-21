package com.arithmetic;

import java.util.*;

/**
 * @author huangzhaoyu
 * @date 2020/1/19 10:09
 */
public class Demo_20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     */
    static Map<Character, Character> map = new HashMap<>();
    static Map<Character, Character> map2 = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        map2.put(')', '(');
        map2.put('}', '{');
        map2.put(']', '[');
    }

    /**
     *  使用栈
     *
     */
    public boolean isValid(String s) {
        int length = s.length();
        //优化：长度为奇数直接返回false
        if (length % 2 != 0) {
            return false;
        }
        LinkedList<Character> lList = new LinkedList<>();
        //第一个元素压入栈中
        for (int i = 0; i < length; i++) {
            //如果栈顶元素等于要压入的数据，栈顶元素出栈，否则压入栈中
            if (lList.size() == 0 || !lList.getLast().equals(map.get(s.charAt(i)))) {
                //优化：如果压入右括号  直接返回false
                if(map2.containsKey(s.charAt(i))){
                    return false;
                }
                lList.add(s.charAt(i));
            } else {
                lList.removeLast();
            }
        }
        return lList.size() > 0 ? false : true;
    }

    /**
     * 递归处理
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = (s.replace("()", "").replace("[]", "").replace("{}", ""));
        }
        return "".equals(s);
    }


    public static void main(String[] args) {
        System.out.println(new Demo_20().isValid("{"));
    }

}
