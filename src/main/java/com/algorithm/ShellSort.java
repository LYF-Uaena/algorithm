package com.algorithm;

import org.apache.commons.lang3.time.StopWatch;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

/**
 * 希尔排序
 *
 * @author LYF
 * @create 2021-04-16 9:38
 * @Version 1.0
 **/
public class ShellSort {

    public static void main(String[] args) {
//        Integer[] integers = ArrayUtils.createArray(new Integer[0], 10000, 0);
        int[] integers = intArray();

        int[] integers1 = integers.clone();
        int[] integers2 = integers.clone();
        int[] integers3 = integers.clone();
        int[] integers4 = integers.clone();
        int[] integers5 = integers.clone();

        StopWatch watch1 = new StopWatch();
        watch1.start();
        sort(integers1);
        watch1.stop();
        System.out.println("第1次执行时长：" + watch1.getTime(TimeUnit.MILLISECONDS) + " 毫秒.");

        StopWatch watch2 = new StopWatch();
        watch2.start();
        sort(integers2);
        watch2.stop();
        System.out.println("第2次执行时长：" + watch2.getTime(TimeUnit.MILLISECONDS) + " 毫秒.");

        StopWatch watch3 = new StopWatch();
        watch3.start();
        sort(integers3);
        watch3.stop();
        System.out.println("第3次执行时长：" + watch3.getTime(TimeUnit.MILLISECONDS) + " 毫秒.");

        StopWatch watch4 = new StopWatch();
        watch4.start();
        sort(integers4);
        watch4.stop();
        System.out.println("第4次执行时长：" + watch4.getTime(TimeUnit.MILLISECONDS) + " 毫秒.");

        StopWatch watch5 = new StopWatch();
        watch5.start();
        sort(integers5);
        watch5.stop();
        System.out.println("第5次执行时长：" + watch5.getTime(TimeUnit.MILLISECONDS) + " 毫秒.");
    }


    /**
     * int[]
     * @return
     */
    public static int[] intArray() {
        SecureRandom random = new SecureRandom();
        int[] array = new int[100000];
        long start = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }
        long end = System.nanoTime();
        System.out.println("生成数组时间： " + (end - start) / 1000000 + " ms");
        return array;
    }

    public static void sort(int[] integers) {
        int shellGap = 3;
        for (int gap = integers.length / shellGap; gap > 0; gap /= shellGap) {
            for (int i = gap; i < integers.length; i++) {
                while (i - gap >= 0 && integers[i] < integers[i - gap]) {
                    int temp = integers[i];
                    integers[i] = integers[i - gap];
                    integers[i - gap] = temp;
                    i -= gap;
                }
            }
        }
    }
}
