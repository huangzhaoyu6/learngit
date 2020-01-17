package com.arithmetic;

import java.util.*;

/**
 * @author huangzhaoyu
 * @date 2020/1/14 13:47
 */
public class Demo_15 {

    /**
     *
     * 给定一个包含 n 个整数的数组 nums，
     * 判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？
     * 找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *
     */


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

    /**
     * 优化了的暴力  将第三次的查询改为散列表查询
     * 依旧时间过长
     */
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


    /**
     * 双指针法
     * <p>
     * 先对数组进行排序
     * 循环数组中的每一个元素 查看是否存在该数字符合条件的数组
     * 用左右两端的指针的和与需要比较的 元素的负数 作比较，
     * 如果和小于该元素，左元素向右移动，如果大于该元素，右元素向左移动
     * 等于该元素的话将该元素存入预先准备的结果集合中，左右指针同时向内移动一次
     * <p>
     * 优化时间复杂度：
     * 1.记录前一次做处理的元素值，每次获取元素时，与之前记录的元素值做比较，如果相等，跳过本次处理
     * 2.当该元素的负数等于左右指针的和时，查看左右指针即将指向的下一个元素是否与当前指针元素相等，如果相等，直接向内移动一次。
     */
    public static List<List<Integer>> threeSum3(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return list;
        }
        int pre = nums[0] + 1;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            int idx = nums[i];
            if (pre == idx) {
                continue;
            }
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int left = nums[l];
                int right = nums[r];
                int sum = right + left;
                if (-idx == sum) {
                    List<Integer> li = new ArrayList<>();
                    li.add(idx);
                    li.add(left);
                    li.add(right);
                    list.add(li);
                    while (l<r && left == nums[l]) {l++;}
                    while (l<r && right == nums[r]) {r--;}
                } else if (-idx < sum) {
                    r--;
                } else {
                    l++;
                }
            }
            pre = idx;
        }
        return list;
    }


    public static void main(String[] args) {
//        [[-2,-2,4],[-2,0,2],[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],]
//        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        int[] nums = {0,0,0};
        System.out.println(threeSum3(nums));
    }

}
