package com.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangzhaoyu
 * @date 2020/1/16 17:46
 */
public class Demo_18 {

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
     * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？
     * 找出所有满足条件且不重复的四元组。
     * <p>
     * 注意：
     * <p>
     * 答案中不可以包含重复的四元组。
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * <p>
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     */


    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*定义一个返回值*/
        List<List<Integer>> result = new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if (nums == null || nums.length < 4) {
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length = nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for (int k = 0; k < length - 3; k++) {
            /*当k的值与前面的值相等时忽略*/
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for (int i = k + 1; i < length - 2; i++) {
                /*当i的值与前面的值相等时忽略*/
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                /*定义指针j指向i+1*/
                int j = i + 1;
                /*定义指针h指向数组末尾*/
                int h = length - 1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }


    public static List<List<Integer>> threeSum3(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        if (length < 4) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 3; i++) {
            //当i的值与前面的值相等时忽略
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //优化：获取当前i及后面三位的和，如果比目标值大，说明后面的没有必要做处理了，因为无论如何后面的数字加起来都不可能等于或者小于target
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                break;
            }
            //优化：获取当前最后一个数及前面三位的和，如果比目标值小，本次循环 直接取下一个i，因为下一个i加上后面的三位，总数还有可能会变大
            if (nums[i] + nums[length-1] + nums[length-2] + nums[length-3] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                //当j的值与前面的值相等时忽略
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = length - 1;
                //优化：获取当前i及后面三位的和，如果比目标值大，说明后面的没有必要做处理了，因为无论如何后面的数字加起来都不可能等于或者小于target
                if (nums[i] + nums[j] + nums[l] + nums[l+1] > target) {
                    break;
                }
                //优化：获取当前最后一个数及前面三位的和，如果比目标值小，本次循环 直接取下一个i，因为下一个i加上后面的三位，总数还有可能会变大
                if (nums[i] + nums[j] + nums[r] + nums[r-1] < target) {
                    continue;
                }
                while (l < r) {
                    int left = nums[l];
                    int right = nums[r];
                    int inum = nums[i];
                    int jnum = nums[j];
                    int sum = inum + jnum + right + left;
                    if (target == sum) {
                        List<Integer> li = new ArrayList<>();
                        li.add(inum);
                        li.add(jnum);
                        li.add(left);
                        li.add(right);
                        list.add(li);
                        while (l < r && left == nums[l]) {
                            l++;
                        }
                        while (l < r && right == nums[r]) {
                            r--;
                        }
                    } else if (target < sum) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;
        System.out.println(threeSum3(nums, target));
    }

}
