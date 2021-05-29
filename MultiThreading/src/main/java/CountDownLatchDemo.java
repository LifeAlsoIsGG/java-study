import lombok.Data;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 使用CountDownLatch模拟赛跑
 * @Datetime: 2021/5/29 23:13:16
 */
@Data
public class CountDownLatchDemo implements Runnable{

    private static CountDownLatch countDownLatchStart;
    private static CountDownLatch countDownLatchEnd;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "准备就绪");
            countDownLatchStart.await();
            //跑路耗时随机秒数
            int spend = new Random().nextInt(9);
            TimeUnit.SECONDS.sleep(spend);
            System.out.println(Thread.currentThread().getName() + "到达终点，耗时" + spend + "秒");
            countDownLatchEnd.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        countDownLatchStart = new CountDownLatch(1);
        countDownLatchEnd = new CountDownLatch(5);


        for (int i = 0; i < 5; i++) {
            new Thread(new CountDownLatchDemo(), "运动员" + (i + 1)).start();
        }

        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("开始跑步");
        //主线程宣布开始跑步
        countDownLatchStart.countDown();

        System.out.println("跑步中");

        try {
            countDownLatchEnd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("跑步结束");
    }


}
