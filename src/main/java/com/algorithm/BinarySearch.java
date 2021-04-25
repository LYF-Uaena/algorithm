package com.algorithm;

import java.util.Arrays;

/**
 * 二分法查找
 *
 * @author LYF
 * @create 2021-04-16 8:55
 * @Version 1.0
 **/
public class BinarySearch {
    public static void main(String[] args) {
        Integer[] its
                = {6377, 7010, 8307, 4414, 1076, 4000, 1676, 9429, 683, 3145, 9696, 4042, 1152, 2113, 3634,
                7618, 9707, 860, 2254, 7615, 8065, 8221, 388, 5853, 1235, 3510, 3099, 3528, 7287, 1068, 4222, 9406,
                1049, 1238, 7479, 3052, 7321, 1568, 7736, 4659, 9809, 1143, 6723, 2105, 9390, 9185, 8758, 8893, 9096,
                9582, 5617, 7116, 2930, 5046, 2328, 9218, 3966, 4616, 4412, 9717, 8909, 7251, 2105, 8947, 296, 2633,
                4204, 233, 8833, 5976, 4462, 5360, 9970, 5148, 3175, 4803, 4192, 969, 8715, 2576, 2546, 7481, 5812,
                1479, 611, 5242, 4856};

        InsertionSort.insertionSort(its);
        System.out.println(Arrays.toString(its));
        long start = System.nanoTime();

        long end = System.nanoTime();
        System.out.println("排序时间" + (end - start) / 1000000 + " ms");

        start = System.nanoTime();
        System.out.println("递归：当前查找key的索引为："
                + recursionHalfFind(its, 0, its.length - 1, 8065));
        end = System.nanoTime();
        System.out.println("递归：运行时间： " + (end - start) + " ns");

        start = System.nanoTime();
        System.out.println("while：当前查找key的索引为："
                + whileHalfFind(its, 8065));
        end = System.nanoTime();
        System.out.println("while：程序运行时间： " + (end - start) + " ns");
    }

    private static <T extends Comparable<T>> int recursionHalfFind(T[] ins, int begin, int end, T key) {
        if (end - begin > 0) {
            int centIndex = (end + begin) / 2;
            if (ins[centIndex].compareTo(key) == 0) {
                return centIndex;
            } else if (ins[centIndex].compareTo(key) < 0) {
                begin = centIndex + 1;
                return recursionHalfFind(ins, begin, end, key);
            } else {
                end = centIndex - 1;
                return recursionHalfFind(ins, begin, end, key);
            }
        } else {
            return ins[begin].compareTo(key) == 0 ? begin : -1;
        }
    }

    private static <T extends Comparable<T>> int whileHalfFind(T[] ins, T key) {
        int begin = 0;
        int end = ins.length - 1;
        while (end - begin > 0) {
            int centIndex = (end + begin) / 2;
            if (ins[centIndex].compareTo(key) == 0) {
                return centIndex;
            } else if (ins[centIndex].compareTo(key) < 0) {
                begin = centIndex + 1;
            } else {
                end = centIndex - 1;
            }
        }
        return ins[begin].compareTo(key) == 0 ? begin : -1;
    }
}
