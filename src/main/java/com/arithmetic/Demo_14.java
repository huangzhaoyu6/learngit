package com.arithmetic;

/**
 * @author huangzhaoyu
 * @date 2020/1/13 18:45
 */
public class Demo_14 {

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
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()){ return "";}
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] str = { "qaq2qwe","qaqq3we","qaqqw4e"};
        System.out.println(longestCommonPrefix(str));
    }

}
