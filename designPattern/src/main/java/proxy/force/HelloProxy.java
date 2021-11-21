package proxy.force;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/14 19:31:20
 */
public class HelloProxy implements HelloInterface {

    private HelloInterface helloInterface = null;

    public HelloProxy(HelloInterface helloInterface) {
        this.helloInterface = helloInterface;
    }

    @Override
    public void sayHello() {
        System.out.println("Before invoke sayHello");
        helloInterface.sayHello();
        System.out.println("After invoke sayHello");
    }

    //代理的代理暂时还没有，就是自己
    public HelloInterface getProxy() {
        return this;
    }
}
