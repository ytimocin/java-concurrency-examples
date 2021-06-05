package com.basetech;

/**
 * Got this example from https://dzone.com/articles/java-volatile-keyword-0
 * Try this example two times: one time with the volatile keyword and
 * another time without the keyword.
 *
 * Explanation with my own words:
 * volatile keyword tells the jvm that MY_VOLATILE_INT can be changed in another thread.
 *
 */
public class VolatileTest {
    private static volatile int MY_VOLATILE_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_VOLATILE_INT;
            while (local_value < 5) {
                if (local_value != MY_VOLATILE_INT) {
                    System.out.println("Got Change for MY_VOLATILE_INT : " + MY_VOLATILE_INT);
                    local_value = MY_VOLATILE_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int local_value = MY_VOLATILE_INT;
            while (MY_VOLATILE_INT < 5) {
                System.out.println("Incrementing MY_VOLATILE_INT to " + (local_value + 1));
                MY_VOLATILE_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
