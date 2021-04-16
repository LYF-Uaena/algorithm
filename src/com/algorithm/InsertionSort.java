package com.algorithm;

import java.util.Arrays;

/**
 * 直接插入排序
 *
 * @author LYF
 * @create 2021-04-16 9:46
 * @Version 1.0
 **/
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {

                while (i - gap >= 0 && arr[i] < arr[i - gap]) {
                    System.out.println("当前交换的下标：" + i + " " + (i - gap));
                    //插入排序采用交换法
                    swap(arr, i, i - gap);
                    i -= gap;
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
