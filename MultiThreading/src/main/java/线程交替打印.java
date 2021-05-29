import io.swagger.models.auth.In;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/4/12 15:04:05
 */
public class 线程交替打印 {

    static class PrintNumber {
        private volatile int number = 1;
        private volatile int value = 1;

        void firstPrint() {
            synchronized (this) {
                while(value != 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                value = 2;
                notifyAll();
            }
        }
        void secondPrint() {
            synchronized (this) {
                while (value != 2) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                value = 3;
                notifyAll();
            }
        }
        void thirdPrint() {
            synchronized (this) {
                while (value!=3) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                value = 1;
                notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        Runnable r1 = () ->{
            for (int i = 0; i < 34; i++) {
                printNumber.firstPrint();
            }
        };
        Runnable r2 = () ->{
            for (int i = 0; i < 33; i++) {
                printNumber.secondPrint();
            }
        };
        Runnable r3 = () ->{
            for (int i = 0; i < 33; i++) {
                printNumber.thirdPrint();
            }
        };

        new Thread(r1, "线程一").start();
        new Thread(r2, "线程二").start();
        new Thread(r3, "线程三").start();


    }
}
