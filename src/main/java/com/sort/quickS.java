package com.sort;

/**
 * @author huangzhaoyu
 * @date 2020/11/30 16:44
 */
public class quickS {

    public static void main(String[] args) {
        int[] a = {19, 2, 3, 90, 67};
        quickS.quick(a);
        for (int num : a) {
            System.out.println(" " + num);
        }
    }

    private static void quick(int[] a) {
        if (a.length > 0) {
            quickSortMethod(a, 0, a.length - 1);
        }
    }

    private static void quickSortMethod(int[] a, int l, int r) {
        if (l < r) {
            int middle = getMiddle(a, l, r);
            quickSortMethod(a, 0, middle - 1);
            quickSortMethod(a, middle + 1, r);
        }
    }

    private static int getMiddle(int[] a, int l, int r) {
        //设定基准
        int temp = a[l];
        while (l < r) {
            while (l < r && a[r] >= temp) {
                r--;
            }
            a[l] = a[r];

            while (l < r && a[l] <= temp) {
                l++;
            }
            a[r] = a[l];
        }
        a[l] = temp;
        return l;
    }


}
