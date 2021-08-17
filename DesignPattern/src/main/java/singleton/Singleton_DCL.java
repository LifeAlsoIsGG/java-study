package singleton;

/**
 * @WebName: Singleton_DCL
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/14  17:13
 * “Welcome,my master”
 */

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * **JDK 版本：**JDK1.5 起
 * **是否 Lazy 初始化：**是
 * **是否多线程安全：**是
 * **实现难度：**较复杂
 * **描述：**这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */

public class Singleton_DCL extends SingletonFather{
    private volatile static Singleton_DCL instance;

    private Singleton_DCL() {
    }

    public static Singleton_DCL getInstance() {
        if (instance == null) {
            synchronized (Singleton_DCL.class) {
                if (instance == null) {
                    instance = new Singleton_DCL();
                }
            }
        }
        return instance;
    }

}
