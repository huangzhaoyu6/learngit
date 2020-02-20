package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/1/31
*/

import java.util.HashMap;

public class Demo_26 {

    /**
     *
     *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     * 说明:
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     */

    /**
     * 创建一个map用来存放不同的元素
     * 设置左右两个指针
     * 左指针依次扫描
     * 如果map中包含左指针代表的元素
     * 将右指针前面所有元素向左移动一位,然后将左指针的值赋给右指针，右指针向左移动一位
     * 否则左指针向右移动一位，并且将该元素放入map中
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int temp = 0;
        if (length < 2) {
            return length;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            if (hashMap.containsKey(nums[left])) {
                temp = nums[left];
                //将left到right的元素都向前移动一位
                for (int i = left + 1; i < right + 1; i++) {
                    nums[i - 1] = nums[i];
                }
                nums[right] = temp;
                right--;
            } else {
                hashMap.put(nums[left], left);
                left++;
            }
        }
        return hashMap.size();
    }


    /**
     * 由于数组是排好序的，如果出现重复元素的话，
     * 不需要把这个元素删了，只需要用后面的元素把它覆盖就好了。
     * <p>
     * 可以用两个指针front和back来实现：
     * <p>
     * 如果back与front正好重复了，front向后移动，直到back和front不重复为止；
     * 此时将front指针的元素复制到back指针的下一个，并且将back向后移一位，
     * 这样子下次作比较时，就是从次大的数字开始做比较，
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 2, 3, 4};
        int len = new Demo_26().removeDuplicates2(arr);
        System.out.println("len:::   " + len);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }


}
