package proxy.dynamic;

import java.lang.reflect.*;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/14 19:46:55
 */
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke " + method.getName());
        Object result = method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return result;
    }

    public static Object getProxy(Object object) {
        InvocationHandler handler = new ProxyHandler(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), handler);
    }
}
