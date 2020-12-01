package com.arithmetic;

/**
 * @author huangzhaoyu
 * @date 2020/5/20 16:35
 */
public class BinarySearchDemo {

    /*int binarySearch(int[] nums, int target) {
        int left = 0, right = ...;

        while(...) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
            ...
            } else if (nums[mid] < target) {
                left = ...
            } else if (nums[mid] > target) {
                right = ...
            }
        }
        return ...;
    }*/

    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target)
            {
                left = mid + 1;
            }
            else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3};
        int target = 2;
        System.out.println(binarySearch(nums,target));

    }


}
