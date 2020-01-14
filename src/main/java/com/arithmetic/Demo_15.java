package com.arithmetic;

import java.util.*;

/**
 * @author huangzhaoyu
 * @date 2020/1/14 13:47
 */
public class Demo_15 {

    /**
     * 暴力解法
     * 利用map去重
     * 时间过长  通过不了
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Map<String, List<Integer>> trr = new TreeMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int m = j + 1; m < nums.length; m++) {
                    if (nums[i] + nums[m] + nums[j] == 0) {
                        List<Integer> arr2 = new ArrayList();
                        arr2.add(nums[i]);
                        arr2.add(nums[m]);
                        arr2.add(nums[j]);
                        Collections.sort(arr2);
                        trr.put(arr2.toString(), arr2);
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(trr.values());
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        Map<String, List<Integer>> trr = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap();
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                //取出A元素的负数-当前元素
                int num = 0 - nums[i] - nums[j];
                if (map.containsKey(num)) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(num);
                    integers.add(nums[j]);
                    integers.add(nums[i]);
                    Collections.sort(integers);
                    trr.put(integers.toString(), integers);
                }
                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(trr.values());
    }


    public static void main(String[] args) {
//        [[-2,-2,4],[-2,0,2],[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],]
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
//        int[] nums = {0,0, 0,0, 0,0};
        System.out.println(threeSum2(nums));
    }

}
