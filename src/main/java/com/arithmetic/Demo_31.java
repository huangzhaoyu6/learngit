package com.arithmetic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author huangzhaoyu
 * @date 2020/3/9 16:32
 */
public class Demo_31 {


    /**
     * 实现获取下一个排列的函数，
     * 算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * 必须原地修改，只允许使用额外常数空间。
     * <p>
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */


    /**
     *  思路：我们就是要找第一个下降的，
     *        然后让他跟后面第一个比它大的数交换，
     *        并把后面的数据变成上升排列的。
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        //数组长度
        int len = nums.length;
        int temp = 0;
        int tag = 0;
        for (int i = len - 1; i > -1; i--) {
            //如果循环到最后一位，他前面也没有元素可以比较了，直接跳出
            if (i == 0) {
                tag = -1;
                break;
            }
            //找第一个下降的
            if (nums[i - 1] < nums[i]) {
                temp = nums[i - 1];
                tag = i - 1;
                break;
            }
        }
        //让他跟后面第一个比它大的数交换
        if (tag != -1) {
            for (int i = len - 1; i > 0; i--) {
                if (nums[i] > temp) {
                    int temp1;
                    temp1 = nums[i];
                    nums[i] = nums[tag];
                    nums[tag] = temp1;
                    break;
                }
            }
            //把后面的数据变成上升排列的
            Arrays.sort(nums, tag + 1, len);
        }else{
            Arrays.sort(nums, 0, len);
        }
    }


    public static void main(String[] args) {
        int[] arr = {3,2,1};
        new Demo_31().nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
