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
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(Integer[] integers) {
        for (int i = 1; i < integers.length; i++) {
            if (integers[i] < integers[i - 1]) {
                Integer temp = integers[i];
                int j = i - 1;
                while (j >= 0 && temp < integers[j]) {
                    integers[j + 1] = integers[j];
                    j--;
                }
                integers[j + 1] = temp;
            }
        }
    }
}
