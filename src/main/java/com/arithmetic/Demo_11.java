package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/1/11
*/

public class Demo_11 {


    /**
     *解法1：暴力法
     * 从第一个桶依次向后遍历，保存最大桶的容量
     *
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int nowHeight = height[i] > height[j] ? height[j] : height[i];//比较两端的桶，取出最低的桶
                int nowWidth = j - i;//取出宽度
                int capacity = nowHeight * nowWidth;
                max = capacity > max ? capacity : max;
            }
        }
        return max;
    }

    /**
     *解法2：双指针
     *  取最左和最右的两个元素  依次向内推进
     *  然后将小的一个向内测移动（因为X*Y求最大时，X不变时，Y值只有逐渐变大，才能不错过最大值）
     */
    public static int maxArea2(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right){
            max = Math.max(Math.min(height[left],height[right])*(right-left),max);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr [] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(arr));
    }

}
