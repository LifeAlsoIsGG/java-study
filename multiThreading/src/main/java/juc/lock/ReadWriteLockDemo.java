package juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 读写锁示例
 * @Datetime: 2021/8/22 22:39:35
 */
public class ReadWriteLockDemo {
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();
    //锁降级标志
    private volatile boolean cacheValid;

    //读线程执行该方法
    public void read(){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读操作正在执行。。。");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "读操作结束。。。");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    //写线程执行该方法
    public void write(){
        writeLock.lock();
        try {
            //在此区域访问(读，写)共享变量
            System.out.println(Thread.currentThread().getName() + "写操作正在执行。。。");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "写操作结束。。。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    //锁降级
    public void downGrade() {
        boolean readLockAcquired = false;
        writeLock.lock();
        try {
            //在此区域访问(读，写)共享变量
            //...
            //当线程在持有写锁的情况下申请读锁readLock
            readLock.lock();
            readLockAcquired = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

        if(readLockAcquired){
            try {
                //读取共享数据

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }
    }

    //锁升级
    public void upGrade() {
        readLock.lock();
        try {
            // Must release read lock before acquiring write lock
            readLock.unlock();
            writeLock.lock();
            try {
                //在此区域访问(读，写)共享变量
                System.out.println(Thread.currentThread().getName() + "写操作正在执行。。。");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "写操作结束。。。");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }




    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();

        //写操作测试  可以知道写操作是互斥的
        Runnable readRunnable = () -> {
            readWriteLockDemo.read();
        };

        Runnable writeRunnable = () -> {
            readWriteLockDemo.write();
        };

        for (int i = 0; i < 5; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(writeRunnable).start();
        }
    }
}
