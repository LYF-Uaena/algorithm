package com.algorithm.utils;

import java.lang.reflect.Array;
import java.security.SecureRandom;

/**
 * @author LYF
 * @create 2021-04-16 9:47
 * @desc
 **/
public class ArrayUtils {

    /**
     * Create array t[].
     *
     * @param <T> the type parameter
     * @param ts  the ts
     * @return the t[]
     */
    public static <T extends Number> T[] createArray(T[] ts, int length, T t) {
        SecureRandom random = new SecureRandom();
        T[] array = newArray(ts.getClass().getComponentType(), length);
        long start = System.nanoTime();

        for (int i = 0; i < length; i++) {
            if (t instanceof Integer) {
                array[i] = (T) new Integer(random.nextInt(length));
            } else if (t instanceof Double) {
                array[i] = (T) new Double(random.nextDouble());
            } else if (t instanceof Float) {
                array[i] = (T) new Float(random.nextFloat());
            } else if (t instanceof Long) {
                array[i] = (T) new Long(random.nextLong());
            }
        }
        long end = System.nanoTime();
        System.out.println("生成数组时间： " + (end - start) / 1000000 + " ms");

        return array;
    }

    @SuppressWarnings({"unchecked"})
    private static <T extends Number> T[] newArray(Class<?> t, int length) {
        return (T[]) Array.newInstance(t, length);
    }
}
