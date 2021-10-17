package jdk8;

import java.util.Optional;
import jdk8.entity.Girl;
import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/10/17 21:42:35
 */
public class OptionalTest {

    /**
     * Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
     * Optional.empty() : 创建一个空的 Optional 实例 Optional.ofNullable(T t)：t可以为null
     */
    @Test
    public void test() {
        Girl girl = new Girl();
        //girl = null;
        //of(T t):保证t是非空的
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(optionalGirl.get());
    }

    @Test
    public void test2() {
        Girl girl = null;
        //ofNullable(T t)：t可以为null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        //orElse(T t1):如果单前的Optional内部封装的t是非空的，则返回内部的t.
        //如果内部的t是空的，则返回orElse()方法中的参数t1.
        Girl girl1 = optionalGirl.orElse(new Girl(""));
        System.out.println(girl1);
    }

}
