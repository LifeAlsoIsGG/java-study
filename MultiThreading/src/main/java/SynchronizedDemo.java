/**
 * @author Long Chen
 * @description Sychronized demo
 * @date 2021-08-08 22:52
 */

public class SynchronizedDemo {
	//锁柄
	private final Object obj1 = new Object();
	private final Object obj2 = new Object();

	//返回一个Runnable线程
	public static Runnable getThread1(SynchronizedDemo obj){
		return () -> {
//			obj.demo1();
			obj.demo2();
		};
	}

	public static Runnable getThread2(SynchronizedDemo obj){
		return () -> {
			obj.demo3();
		};
	}

	public static void run(){
		System.out.println("我是线程" + Thread.currentThread().getName());
		try {
			System.out.println("线程" + Thread.currentThread().getName() + "正在睡觉");
			Thread.sleep(3000);
			System.out.println("线程" + Thread.currentThread().getName() + "起床了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "结束");
	}

	//1.代码块：锁柄为括号中的对象，可以为普通对象，this，类对象
	public void demo1(){
		System.out.println("对象锁");

		// 这个代码块使用的是第一把锁，当他释放后，后面的代码块由于使用的是第二把锁，因此可以马上执行
		synchronized (obj1) {
			System.out.println("block1锁,我是线程" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("block1锁,"+Thread.currentThread().getName() + "结束");
		}

		synchronized (obj2) {
			System.out.println("block2锁,我是线程" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("block2锁,"+Thread.currentThread().getName() + "结束");
		}

		synchronized (this) {
			System.out.println("对象本身锁,我是线程" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("对象本身锁,"+Thread.currentThread().getName() + "结束");
		}

		synchronized (SynchronizedDemo.class) {
			System.out.println("类本身锁,我是线程" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("类本身锁,"+Thread.currentThread().getName() + "结束");
		}
	}

	//2.同步托普通方法：默认锁住的是对象本身
	public synchronized void demo2(){
		System.out.println("对象锁");
		run();
	}

	public static synchronized void demo3(){
		System.out.println("类锁");
		run();
	}


	public static void main(String[] args) {
		SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

		//代码块用法
		new Thread(getThread1(synchronizedDemo)).start();
		new Thread(getThread2(synchronizedDemo)).start();
	}

}
