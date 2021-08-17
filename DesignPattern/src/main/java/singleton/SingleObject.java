package singleton;

/**
 * @WebName: Singleton
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/14  11:31
 * “Welcome,my master”
 * 单例模式
 */
public class SingleObject {

    //创建 SingleObject 的一个对象
    private static SingleObject instance = new SingleObject();

    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject() {
    }

    //获取唯一可用的对象
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMsg() {
        System.out.println("单例模式");
    }

    public static void main(String[] args) {
        SingleObject object = new SingleObject();
        object.showMsg();

        System.out.println("202001".substring(4, 6));
        System.out.println(0 % 9);

    }
}
