package create;

import io.netty.util.concurrent.SingleThreadEventExecutor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Package: sort
 * @Author: Chen Long
 * @Description: 线程创建方式
 * @Datetime: 2021/5/11 19:43:44
 */
public class ThreadCreation {


    //1. 线程1：根据继承Thread类并重写run方法的线程
    static class ByThread extends Thread{

        @Override
        public void run(){
            System.out.println("线程1：根据继承Thread类并重写run方法的线程");
            for (int i = 0; i < 20; i++) {
                System.out.println("线程1：" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //2. 线程2：根据实现Runnable接口并重写run方法的线程
    static class ByRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("线程2：根据实现Runnable接口并重写run方法的线程");
            for (int i = 0; i < 20; i++) {
                System.out.println("线程2：" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //3. 线程3：覆写Callable接口实现多线程
    static class ByCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("线程3：覆写Callable接口实现多线程");
            return "线程3返回值";
        }
    }

    //4. 线程4：线程池创建线程
    static void ByThreadPool(){
        ExecutorService executor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
        executor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });


    }


    public static void main(String[] args) {
//        线程1：根据继承Thread类并重写run方法的线程
        Thread byThread = new ByThread();

//        线程2：根据实现Runnable接口并重写run方法的线程
        Thread byRunnable = new Thread(new ByRunnable());
        Callable<String> callable  = new ByCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);

//        线程3：覆写Callable接口实现多线程
        Thread byCallable = new Thread(futureTask);

        List<Thread> threadList = new ArrayList<>(3);
        threadList.add(byThread);
        threadList.add(byCallable);
        threadList.add(byCallable);

        threadList.forEach(Thread::start);

    }
}
