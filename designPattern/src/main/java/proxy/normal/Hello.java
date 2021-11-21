package proxy.normal;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/14 19:30:56
 */
public class Hello implements HelloInterface {

    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }

    @Override
    public void sayHi() {
        System.out.println("Hi");
    }
}
