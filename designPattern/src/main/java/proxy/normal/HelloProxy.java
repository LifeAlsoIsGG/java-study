package proxy.normal;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/14 19:31:20
 */
public class HelloProxy implements HelloInterface {

    private HelloInterface helloInterface = new Hello();

    @Override
    public void sayHello() {
        System.out.println("Before invoke sayHello");
        helloInterface.sayHello();
        System.out.println("After invoke sayHello");
    }

    @Override
    public void sayHi() {

    }
}
