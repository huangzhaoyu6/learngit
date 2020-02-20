package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/2/1
*/

public class Demo_27 {

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * 示例 1:
     * 给定 nums = [3,2,2,3], val = 3,
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * 注意这五个元素可为任意顺序。
     */

    /**
     * 设置左右两个指针
     * 左指针依次扫描
     * 如果左指针代表的元素等于val
     * 将左指针和右指针交换，右指针向左移动一位
     * 否则左指针向右移动一位，拿下一个元素和val作比较
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right-1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    /**
     *  设立两个指针，i慢指针，j快指针
     *  将快指针与val进行比较，
     *  如果快指针等于val，慢指针留在原地，代表这个元素要被删除，
     *  快指针向后走寻找下一个可以放在i位置的元素
     *  当快指针不等于val时，将快指针的值赋值给慢指针
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        int len = new Demo_27().removeElement(arr,0);
        System.out.println("len:::   " + len);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
}
