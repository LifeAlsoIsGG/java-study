package CreateThread;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 创建线程
 * @Datetime: 2021/5/8 16:09:54
 */
public class CreateThread extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread.run()");
    }


    public static void main(String[] args) {
        CreateThread myThread1 = new MyThread();
        CreateThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
    }
}
