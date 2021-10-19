package jdk8.stream;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import jdk8.entity.Employee;
import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: stream实例化
 * @Datetime: 2021/10/17 17:09:10
 */
public class StreamCreation {

    //创建 Stream方式一：通过集合
    @Test
    public void test() {
        List<Employee> employees = Employee.getEmployees();

//        default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

//        default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    //创建 Stream方式二：通过数组
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Hom");
        Employee e2 = new Employee(1002, "Nut");
        Employee[] arr1 = new Employee[]{e1, e2};

        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建 Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建 Stream方式四：创建无限流
    @Test
    public void test4() throws FileNotFoundException {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        //遍历前10个偶数
        //iterate生成的是装箱的对象，必须拆箱成数字才能求和
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

//      生成
//      public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        System.out.println("++++++++++++++++++++++");

        //使用 BufferedReader.lines() 方法，将每行内容转成流
        BufferedReader reader = new BufferedReader(new FileReader("D:\\repository\\java-study\\text.txt"));
        Stream<String> lineStream = reader.lines();
        lineStream.forEach(System.out::println);

        System.out.println("++++++++++++++++++++++");

        //使用 Pattern.splitAsStream() 方法，将字符串分隔成流
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
        stringStream.forEach(System.out::println);
    }
}
