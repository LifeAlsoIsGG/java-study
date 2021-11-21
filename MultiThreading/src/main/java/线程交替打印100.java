import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/4/12 15:04:05
 */
public class 线程交替打印100 {

    static class PrintNumber {

        private final AtomicInteger number = new AtomicInteger(1);
        private volatile int value = 1;

        synchronized void firstPrint() {
            while (value != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
            number.incrementAndGet();
            value = 2;
            notifyAll();
        }

        synchronized void secondPrint() {
            while (value != 2) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
            number.incrementAndGet();
            value = 3;
            notifyAll();
        }

        synchronized void thirdPrint() {
            while (value != 3) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
            number.incrementAndGet();
            value = 1;
            notifyAll();
        }
    }


    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        Runnable r1 = () -> {
            for (int i = 0; i < 34; i++) {
                printNumber.firstPrint();
            }
        };
        Runnable r2 = () -> {
            for (int i = 0; i < 33; i++) {
                printNumber.secondPrint();
            }
        };
        Runnable r3 = () -> {
            for (int i = 0; i < 33; i++) {
                printNumber.thirdPrint();
            }
        };

        new Thread(r1, "线程一").start();
        new Thread(r2, "线程二").start();
        new Thread(r3, "线程三").start();


    }
}
