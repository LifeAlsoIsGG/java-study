package proxy.force;

import java.util.Objects;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/14 19:30:56
 */
public class Hello implements HelloInterface {

    //强制使用代理
    private HelloInterface proxy = null;

    @Override
    public void sayHello() {
        if (isProxy()) {
            System.out.println("Hello world!");
        } else {
            System.out.println("请使用代理类操作");
        }

    }


    //找到自己的代理
    public HelloInterface getProxy() {
        this.proxy = new HelloProxy(this);
        return this.proxy;
    }

    //校验是否是代理访问
    private boolean isProxy() {
        return Objects.nonNull(proxy);
    }
}
