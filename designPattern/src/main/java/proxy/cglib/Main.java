package proxy.cglib;

import org.junit.Test;
import proxy.normal.Hello;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/16 21:34:03
 */
public class Main {

    @Test
    public void test() {
        CglibProxy proxy = new CglibProxy();
        //通过生成子类的方式创建代理类
        Hello proxyImp = (Hello) proxy.getProxy(Hello.class);
        proxyImp.sayHello();
        proxyImp.sayHi();
    }

}
