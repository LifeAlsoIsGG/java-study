package proxy.force;

import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/14 16:06:23
 */
public class Main {

    /**
     * @description: 强制使用代理
     **/
    @Test
    public void normalProxyTest() {
        HelloInterface hello = new Hello();
        hello.sayHello();        //请使用代理类操作

        HelloInterface helloProxy = hello.getProxy();
        helloProxy.sayHello();
    }

}
