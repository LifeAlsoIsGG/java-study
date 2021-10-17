package jdk8;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 函数式接口
 * @Datetime: 2021/10/17 15:09:05
 */

/**
 * java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 */
public class FunctionTest {

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test() {
        happyTime(30, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("熬夜太累了，点个外卖，价格为：" + aDouble);
            }
        });
        System.out.println("+++++++++++++++++++++++++");

        //Lambda表达式写法
        happyTime(20, money -> System.out.println("熬夜太累了，吃口麻辣烫，价格为：" + money));
    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre) {

        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;

    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("长安", "上京", "江南", "渝州", "凉州", "兖州");

        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("州");
            }
        });

        System.out.println(filterStrs);

        List<String> filterStrs1 = filterString(list, s -> s.contains("州"));
        System.out.println(filterStrs1);
    }
}