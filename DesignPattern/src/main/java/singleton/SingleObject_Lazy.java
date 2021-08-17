package singleton;

/**
 * @WebName: SingleObject_Lazy
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/14  16:46
 * “Welcome,my master”
 */

/**
 * 懒汉式线程不安全
 * **是否 Lazy 初始化：**是
 * **是否多线程安全：**否
 * **实现难度：**易
 * **描述：**这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class SingleObject_Lazy {
    private static SingleObject_Lazy instance;

    private SingleObject_Lazy() {
    }

    public static SingleObject_Lazy getInstance() {
        if (instance == null) {
            instance = new SingleObject_Lazy();
        }
        return instance;
    }

    public void showMsg() {
        System.out.println("单例模式_懒汉式_线程不安全");
    }
}
