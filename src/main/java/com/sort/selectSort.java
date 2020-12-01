package com.sort;

/**
 * @author huangzhaoyu
 * @date 2020/11/30 13:26
 */
public class selectSort {


    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3,0};
        int[] res = selectSortMethod(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] selectSortMethod(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int temIdx = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[temIdx]){
                    temIdx = j;
                }
            }

            int temp = arr[temIdx];
            arr[temIdx] = arr[i];
            arr[i] = temp;

        }
        return arr;
    }

}
