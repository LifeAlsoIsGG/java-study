package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Project: Java-Study
 * @Package: multithreading
 * @ClassName: CAS_Demo
 * @Author: Chen Long
 * @Description: CAS的Demo
 * @Datetime: 2020/11/19  14:47
 * https://blog.csdn.net/v123411739/article/details/79561458
 */
public class CAS_Demo {
    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase() {
        /*race++;并非原子操作，经过下面三个步骤，取值，+1，写值*/
        race.getAndIncrement();
        race.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        /*while (Thread.activeCount() > 1) {
            Thread.yield();
        }*/

        System.out.println(race);

    }
}
