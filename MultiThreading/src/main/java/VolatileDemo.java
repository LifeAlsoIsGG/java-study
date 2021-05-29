/**
 * @Package: sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/13 14:31:50
 */
public class VolatileDemo {

    static volatile boolean isCanceled = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!isCanceled) {
//                 System.out.println("hello");
            }
        }).start();
        System.out.println("come here");
        Thread.sleep(1000);
        isCanceled = true;
    }
}
