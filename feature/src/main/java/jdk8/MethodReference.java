package jdk8;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;
import jdk8.entity.Employee;
import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 方法引用
 * @Datetime: 2021/10/17 16:25:29
 */
public class MethodReference {

    // 情况一：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test() {
        Employee emp = new Employee(4, "Nice", 19, 4200);

        Consumer<String> c1 = str -> System.out.println(str);
        c1.accept("兖州");

        System.out.println("+++++++++++++");
        PrintStream ps = System.out;
        Consumer<String> c2 = System.out::println;
        c2.accept("xian");
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2() {
        Employee emp = new Employee(4, "Nice", 19, 4200);

        Supplier<String> sk1 = () -> emp.getName();
        System.out.println(sk1.get());

        System.out.println("*******************");
        Supplier<String> sk2 = emp::getName;
        System.out.println(sk2.get());
    }

    // 情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3() {
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(21, 20));

        System.out.println("+++++++++++++++");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(15, 7));
    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {
        Function<Double, Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };

        System.out.println("++++++++++++++++++");

        Function<Double, Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(14.1));

        System.out.println("++++++++++++++++++");

        Function<Double, Long> func2 = Math::round;
        System.out.println(func2.apply(17.4));
    }

    //构造器引用
    //一、构造器引用
    //和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
    //抽象方法的返回值类型即为构造器所属的类的类型
    //Supplier中的T get()
    //Employee的空参构造器：Employee()
    @Test
    public void test5() {
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());

        System.out.println("+++++++++++++++++++");

        Supplier<Employee> sk1 = () -> new Employee();
        System.out.println(sk1.get());

        System.out.println("+++++++++++++++++++");

        Supplier<Employee> sk2 = Employee::new;
        System.out.println(sk2.get());
    }

    //Function中的R apply(T t)
    @Test
    public void test6() {
        Function<Integer, Employee> f1 = id -> new Employee(id);
        Employee employee = f1.apply(7793);
        System.out.println(employee);

        System.out.println("+++++++++++++++++++");

        Function<Integer, Employee> f2 = Employee::new;
        Employee employee1 = f2.apply(4545);
        System.out.println(employee1);
    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test7() {
        BiFunction<Integer, String, Employee> f1 = (id, name) -> new Employee(id, name);
        System.out.println(f1.apply(2513, "Fruk"));

        System.out.println("*******************");

        BiFunction<Integer, String, Employee> f2 = Employee::new;
        System.out.println(f2.apply(9526, "Bon"));
    }

    //数组引用
    //可以把数组看做是一个特殊的类，则写法与构造器引用一致。
    @Test
    public void test8() {
        Function<Integer, String[]> f1 = length -> new String[length];
        String[] arr1 = f1.apply(7);
        System.out.println(Arrays.toString(arr1));

        System.out.println("+++++++++++++++++++");

        Function<Integer, String[]> f2 = String[]::new;
        String[] arr2 = f2.apply(9);
        System.out.println(Arrays.toString(arr2));
    }
}



