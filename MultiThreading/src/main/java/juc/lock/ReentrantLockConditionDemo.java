package juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Long Chen
 * @description ReentrenLock使用
 * @date 2021-08-05 23:58
 */

public class ReentrantLockConditionDemo {
	private Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();

	//返回一个线程
	public Runnable getThread(){
		return () -> {
			//上锁
			lock.lock();
			try {
				for(int i = 0; i < 5; i++) {
					System.out.println("当前线程名： "+ Thread.currentThread().getName()+" ,i = "+i);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//释放锁
				lock.unlock();
			}
		};
	}

	//使用condition
	public Runnable getThread_2(){
		return () -> {
			lock.lock();
			try {
				System.out.println("当前线程名:"+Thread.currentThread().getName()+" 开始等待时间：" + System.currentTimeMillis());
				//线程等待
				condition.await();
				System.out.println("我陷入了等待...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
				System.out.println("锁被释放了");
			}
		};
	}

	//使用condition signal()来通知被await()的方法
	public void signal(){
		lock.lock();
		try {
			System.out.println("结束等待时间："+System.currentTimeMillis());
			//通知等待线程
			condition.signal();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockConditionDemo reentrantLockConditionDemo = new ReentrantLockConditionDemo();
//		Runnable myReentrantLock =  lockDemo.getThread();
//		List<Thread> threads = new ArrayList<Thread>(3);
//		for (int i = 0; i < 3; i++) {
//			threads.add(new Thread(myReentrantLock));
//		}
//		threads.forEach(Thread::start);

		Thread thread1 = new Thread(reentrantLockConditionDemo.getThread_2(),"线程1");
		thread1.start();
		Thread.sleep(3000);
		//通知被condition await的线程
		reentrantLockConditionDemo.signal();
	}
}
