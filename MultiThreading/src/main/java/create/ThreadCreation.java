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
    static void byThreadPool() throws ExecutionException, InterruptedException {
//        ExecutorService executor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue(10));

        //线程池数量
        int poolNum = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(5);


        List<Future<String>> futureList = new ArrayList<Future<String>>(10);
        for(int i = 0; i < poolNum; i++)
        {
            //Thread.sleep(1000);
            //无返回值
            //executorService.execute(thread);

            //有返回值
            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("线程执行有返回值");
                    return "我是线程结束后的返回值";
                }

            });

            futureList.add(future);
        }

        //关闭线程池
        executorService.shutdown();

        for (Future future : futureList){
            future.get();
        }

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*//        线程1：根据继承Thread类并重写run方法的线程
        Thread byThread = new ByThread();

//        线程2：根据实现Runnable接口并重写run方法的线程
        Thread byRunnable = new Thread(new ByRunnable());


//        线程3：覆写Callable接口实现多线程
        Callable<String> callable  = new ByCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread byCallable = new Thread(futureTask);

        List<Thread> threadList = new ArrayList<>(3);
        threadList.add(byThread);
        threadList.add(byRunnable);
        threadList.add(byCallable);

        threadList.forEach(Thread::start);*/


        //线程池创建并启动线程
        byThreadPool();

    }
}
