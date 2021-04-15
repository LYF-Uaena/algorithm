package com.algorithm;

/**
 * The type Main.
 *
 * @author LYF
 */
public class Main {
    public static void main(String[] args) {
        Integer[] its = new Integer[100000];

        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            its[i] = i;
        }
        long end = System.nanoTime();

        System.out.println("程序运行时间： " + (end - start) + "ns");

        System.out.println();
        start = System.nanoTime();
        System.out.println("递归：当前查找key的索引为："
                + recursionHalfFind(its, 0, its.length - 1, 39525));
        end = System.nanoTime();
        System.out.println("程序运行时间： " + (end - start) + "ns");

        start = System.nanoTime();
        System.out.println("while：当前查找key的索引为："
                + whileHalfFind(its, 39525));
        end = System.nanoTime();
        System.out.println("程序运行时间： " + (end - start) + "ns");
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
