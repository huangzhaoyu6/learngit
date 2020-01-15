package com.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangzhaoyu
 * @date 2020/1/15 13:03
 */
public class Demo_16 {

    public static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int sum2 = 0;
        if (length <= 3) {
            for (int i = 0; i < nums.length; i++) {
                sum2 += nums[i];
            }
            return sum2;
        }
        Arrays.sort(nums);
        //代表target - sum的差
        int pre = Math.abs(nums[length - 1] + nums[length - 2] + nums[length - 3])+Math.abs(target);

        for (int i = 0; i < length; i++) {
            int idx = nums[i];
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int left = nums[l];
                int right = nums[r];
                int sum = right + left + idx;
                if (target == sum) {
                    return sum;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
                int nowpre = Math.abs(target - sum);
                if (nowpre <= pre) {
                    pre = nowpre;
                    sum2 = sum;
                }
            }
        }
        return sum2;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        int target = 0;
        System.out.println(threeSumClosest(nums, target));
    }

}
