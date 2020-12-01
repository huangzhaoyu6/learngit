package com.sort;

/**
 * @author huangzhaoyu
 * @date 2020/11/30 13:21
 */
public class maopao {

    private static int[] mpSort(int[] arr) {

        if(arr.length <= 1){
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3,0};
        int[] res = mpSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }


}
