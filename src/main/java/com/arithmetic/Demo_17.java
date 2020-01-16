package com.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangzhaoyu
 * @date 2020/1/15 16:52
 */
public class Demo_17 {


     Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

     List<String>  output = new ArrayList<String>();

    /***
     * 回溯是一种通过穷举所有可能情况来找到所有解的算法。
     * 如果一个候选解最后被发现并不是可行解，
     * 回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解。
     *
     * 给出如下回溯函数 backtrack(combination, next_digits) ，
     * 它将一个目前已经产生的组合 combination 和接下来准备要输入的数字 next_digits 作为参数。
     *
     * 如果没有更多的数字需要被输入，那意味着当前的组合已经产生好了。
     * 如果还有数字需要被输入：
     * 遍历下一个数字所对应的所有映射的字母。
     * 将当前的字母添加到组合最后，也就是 combination = combination + letter 。
     * 重复这个过程，输入剩下的数字： backtrack(combination + letter, next_digits[1:]) 。
     *
     */


    /**
     *  将next_digits对应的数组中的每一个元素 都拼接到combination字符串后
     * @param combination
     * @param next_digits
     */
    public  void backtrack(String combination, String next_digits) {
        //如果下一个需要解析的字母为空，证明已经组合好最终字符串
        if (next_digits.length() == 0) {
            output.add(combination);
        }else {
            //取出本次需要追加到combination后面的数组
            String letters = phone.get(next_digits.charAt(0)+"");
            for (int i = 0; i < letters.length(); i++) {
                //获取到需要拼接的字母
                String letter = letters.charAt(i)+"";
                //拼接到当前串的后面，作为下一次需要处理的字符串，再将需本次处理过的数字去掉
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public  List<String> letterCombinations(String digits) {
        if (digits.length() != 0){backtrack("", digits);}
        return output;
    }


    public static void main(String[] args) {
        List<String> res = new Demo_17().letterCombinations("");
        System.out.println(res.toString());
    }

}
