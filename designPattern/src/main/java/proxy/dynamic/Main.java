package proxy.dynamic;

import java.lang.reflect.*;
import org.junit.Test;
import proxy.normal.Hello;
import proxy.normal.HelloInterface;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/14 17:23:13
 */
public class Main {

    /**
     * @description:
     **/
    @Test
    public void test() throws Exception {
        //通过该方法用class造一个同接口下的代理class
        Class proxyClass = Proxy.getProxyClass(HelloInterface.class.getClassLoader(), HelloInterface.class);
        //生成构造器
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        constructor.setAccessible(true);
        //反射构建实例
        HelloInterface helloProxy = (HelloInterface) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HelloInterface hello = new Hello();
                System.out.println("Before invoke " + method.getName());
                Object result = method.invoke(hello, args);
                System.out.println("After invoke " + method.getName());
                return result;
            }
        });
        helloProxy.sayHello();
    }

    @Test
    public void test2() {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloInterface hello = new Hello();
        HelloInterface helloProxy = (HelloInterface) ProxyHandler.getProxy(hello);
        helloProxy.sayHello();
        helloProxy.sayHi();
    }

}
