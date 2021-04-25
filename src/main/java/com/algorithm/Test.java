package com.algorithm;

import java.util.concurrent.ThreadFactory;

/**
 * @author LYF
 * @create 2021-04-19 9:15
 * @desc
 **/
public class Test {

    abstract static class Door {
        abstract void open();

        abstract void close();
    }

    interface Alarm {
        void alarm();
    }

    static class AlarmDoor extends Door implements Alarm {
        @Override
        void open() {
        }

        @Override
        void close() {
        }

        @Override
        public void alarm() {
        }
    }

    class test1 extends Door {

        @Override
        void open() {
        }

        @Override
        void close() {
        }
    }
}
