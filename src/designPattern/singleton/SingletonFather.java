package designPattern.singleton;

/**
 * @Project: DataStructure&Algorithm
 * @Package: designPattern.singleton
 * @ClassName: SingletonFather
 * @Author: Chen Long
 * @Date: 2020/10/19  22:39
 * @Description: 单例父类
 */
public class SingletonFather {

    public void showMsg(SingletonFather obj){
        if(obj instanceof Singleton_DCL){
            System.out.println("双重校验锁DCL");
        }else if (obj instanceof Singleton_Hungry){
            System.out.println("饿汉式");
        }else if (obj instanceof Singleton_StaticClass){
            System.out.println("静态内部类");
        }
    }
}
