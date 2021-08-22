package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @WebName: Main
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/14  15:31
 * “Welcome,my master”
 */
public class SingletonMain {

	//通过反射破坏从而创建多个单例对象
	public static void destroyByReflect(Class clz)
		throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Constructor c = clz.getDeclaredConstructor();
		if(ObjectUtils.isNotEmpty(c)){
			c.setAccessible(true);
			Singleton_DCL singleton_dcl = (Singleton_DCL) c.newInstance();
			Singleton_DCL singleton_dcl_2 = (Singleton_DCL) c.newInstance();
			System.out.println("destoryByReflect");
			System.out.println(Objects.equals(singleton_dcl, singleton_dcl_2));
		}
	}

    public static void main(String[] args)
	    throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

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

	    destroyByReflect(Singleton_DCL.class);
	    System.out.println("单例模式无法通过反射构造");
	    destroyByReflect(Singleton_Enum.class);












    }
}
