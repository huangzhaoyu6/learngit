package com.sort;

/**
 * @author huangzhaoyu
 * @date 2020/11/30 14:48
 */
public class quickSort {

    /**
     * 将数组中的第一个元素作为基准，然后对这个基准的两边进行分区，大的在右边，小的在左边
     * 获取数组的左右元素下标
     * 取出数组中第一元素作为基数，
     * 从右边开始，如果该元素小于基准就继续向前迭代，直到遍历到大于或者等于基准的元素时，将该元素存储到左端遍历到的位置
     * 然后开始从左向右遍历，如果该元素小于基准元素，则继续向右端遍历，直到遍历到大于或者等于基准元素时，将该元素存储到右端遍历的位置
     * 循环进行上面两步，直到左右指针指到同一个地方，设置该位置元素为基准元素。返回基准元素的下标。
     * 将上一次排序后的基准左右分区，重复进行排序。
     * @param a
     */
    public static void quick(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    /**
     * 快速排序
     *
     * @param a
     */
    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }

    /**
     * 获取中间下标
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int getMiddle(int[] a, int low, int high) {
        //基准元素
        int temp = a[low];
        while (low < high) {
            //从右边开始，如果该元素大于基准就继续向前迭代，直到遍历到小于或者等于基准的元素时，将该元素存储到左端遍历到的位置
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            //然后开始从左向右遍历，如果该元素小于基准元素，则继续向右端遍历，直到遍历到大于或者等于基准元素时，将该元素存储到右端遍历的位置
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        //插入到排序后正确的位置
        a[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        int[] a = {19, 2, 3, 90, 67};
        quickSort.quick(a);
        for (int num : a) {
            System.out.println(" " + num);
        }
    }

}
