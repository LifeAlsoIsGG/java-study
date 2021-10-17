package jdk8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import org.junit.Test;

/**
 * @package: lambda
 * @author: long chen
 * @description:
 * @datetime: 2021/3/27  22:03:54
 */

/**
 * Lambda表达式的使用
 * <p>
 * 1.举例： (o1,o2) -> Integer.compare(o1,o2); 2.格式： -> :lambda操作符 或 箭头操作符 ->左边：lambda形参列表 （其实就是接口中的抽象方法的形参列表） ->右边：lambda体 （其实就是重写的抽象方法的方法体）
 * <p>
 * 3.Lambda表达式的使用：（分为6种情况介绍）
 * <p>
 * 总结： ->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略 ->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 */
public class LambdaTest {

    //语法格式一：无参，无返回值
    @Test
    public void test() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("长安欢迎您");
            }
        };
        r1.run();
        System.out.println("+++++++++++++++++++++++++|");
        Runnable r2 = () -> System.out.println("长安欢迎您");
        r2.run();
    }

    //语法格式二：Lambda 需要一个参数，但是没有返回值。
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("善与恶的区别是什么？");

        System.out.println("+++++++++++++++++++");

        Consumer<String> c1 = (String s) -> {
            System.out.println(s);
        };
        c1.accept("先天人性无善恶,后天人性有善恶。");
    }

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3() {
        Consumer<String> c1 = (String s) -> {
            System.out.println(s);
        };
        c1.accept("先天人性无善恶,后天人性有善恶。");

        System.out.println("---------------------");

        //括号也可以省略
        Consumer<String> c2 = (s) -> {
            System.out.println(s);
        };
        c2.accept("如果没有邪恶的话我们怎么会知道人世间的那些善良呢？");
    }

    @Test
    public void test4() {
        ArrayList<String> list = new ArrayList<>();//类型推断

        int[] arr = {1, 2, 3};//类型推断
    }

    //语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6() {
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(c1.compare(15, 23));

        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\");

        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(16, 8));
    }

    //语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test7() {
        Comparator<Integer> c1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };

        System.out.println(c1.compare(16, 8));

        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\");

        Comparator<Integer> c2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println(c2.compare(17, 24));
    }

    @Test
    public void test8() {
        Consumer<String> c1 = s -> {
            System.out.println(s);
        };
        c1.accept("先天人性无善恶,后天人性有善恶。");

        System.out.println("---------------------");

        Consumer<String> c2 = s -> System.out.println(s);

        c2.accept("如果没有邪恶的话我们怎么会知道人世间的那些善良呢？");
    }

    public static void main(String[] args) {

        LambdaTest tester = new LambdaTest();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
            System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
            System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {

        int operation(int a, int b);
    }

    interface GreetingService {

        void sayMessage(String message);

    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
