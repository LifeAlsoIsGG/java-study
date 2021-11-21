package proxy.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.*;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/16 21:32:32
 */
public class CglibProxy implements MethodInterceptor {

    private final Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    //实现MethodInterceptor接口方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
        MethodProxy proxy) throws Throwable {
        System.out.println("前置代理");
        //通过代理类调用父类中的方法
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("后置代理");
        return result;
    }
}
