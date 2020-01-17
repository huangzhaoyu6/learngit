package com.arithmetic;

/**
 * @author huangzhaoyu
 * @date 2020/1/13 18:45
 */
public class Demo_14 {


    /**
     *
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     *
     */

    /**
     *  水平扫描法
     *  如果数组为空，直接返回空字符串
     *  简化思路为
     *  LCP(S1​…Sn​)=LCP(LCP(LCP(S1​,S2​),S3​),…Sn​)
     *  所以只需要将前一次计算所得值，作为参数再次传入该方法
     *  迭代完成时，就能获得最终解
     * */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){ return "";}
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //该方法为获取公共前缀  LCP(prefix，str)
            //判断第i个字符串中是否包含公共前缀
            while (strs[i].indexOf(prefix) != 0) {
                //如果不包含 去掉当前的公共前缀的最后一位
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()){ return "";}
            }
        }
        return prefix;
    }

    /**
     * 二分法
     *
     *
     */

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        //取出最短的字符串长度，从最左边开始循环，当碰到不等的字符时，截取左侧的字符串为公共前缀
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) ){
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        String[] str = { "qaqqw1e","qaqqw2e","qaqqw3e","qaqqw4e","qaqqw5e","qaqqw6e","qaqqw7e"};
        System.out.println(new Demo_14().longestCommonPrefix2(str));
    }

}
