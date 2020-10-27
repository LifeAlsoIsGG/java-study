package designPattern.singleton;

/**
 * @Project: DataStructure&Algorithm
 * @Package: designPattern.singleton
 * @ClassName: Singleton_StaticClass
 * @Author: Chen Long
 * @Date: 2020/10/19  22:29
 * @Description: 静态内部类
 */
public class Singleton_StaticClass extends SingletonFather{
    private Singleton_StaticClass() {
    }

    private static class SingletonInstance{
        private static final Singleton_StaticClass INSTANCE = new Singleton_StaticClass();
    }


    public static Singleton_StaticClass getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
