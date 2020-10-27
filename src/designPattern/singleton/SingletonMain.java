package designPattern.singleton;

/**
 * @WebName: Main
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/14  15:31
 * “Welcome,my master”
 */
public class SingletonMain {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(SingleObject_Lazy.getInstance());
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(SingleObject_Lazy.getInstance());
                }
            }
        });
        t1.start();
        t2.start();

        /*普通模式*/
        SingleObject object = SingleObject.getInstance();
        object.showMsg();
        /*懒汉式线程不安全*/
        SingleObject_Lazy object_lazy = SingleObject_Lazy.getInstance();
        object_lazy.showMsg();
        /*懒汉式线程安全*/
        Singleton_Lazy_Synchronized object_lazy_synchronized = Singleton_Lazy_Synchronized.getInstance();
        object_lazy_synchronized.showMsg();
        /*饿汉式*/
        Singleton_Hungry singleton_Hungry = Singleton_Hungry.getInstance();
        singleton_Hungry.showMsg(singleton_Hungry);
        /*双重校验锁*/
        Singleton_DCL singleton_DCL = Singleton_DCL.getInstance();
        singleton_DCL.showMsg(singleton_DCL);
        /*静态内部类*/
        Singleton_StaticClass singleton_StaticClass = Singleton_StaticClass.getInstance();
        singleton_StaticClass.showMsg(singleton_StaticClass);
        /*枚举*/
        Singleton_Enum instance = Singleton_Enum.INSTANCE;
        instance.method();











    }
}
