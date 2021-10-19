package jdk8.stream;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: Stream中间操作
 * @Datetime: 2021/10/17 18:25:41
 */

import java.util.*;
import java.util.stream.Stream;
import jdk8.entity.Employee;
import org.junit.Test;

public class StreamMiddle {

    //1-筛选与切片
    @Test
    public void filterAndSlices() {
        List<Employee> list = Employee.getEmployees();
//        filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        //练习：查询员工表中薪资大于7000的员工信息
        list.stream().filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println("+++++++++++++++++++++++");
//        limit(n)——截断流，使其元素不超过给定数量。
        list.stream().limit(3).forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++");

//        skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().skip(3).forEach(System.out::println);

        System.out.println("+++++++++++++++++++++++");
//        distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素

        list.add(new Employee(1013, "李飞", 42, 8500));
        list.add(new Employee(1013, "李飞", 41, 8200));
        list.add(new Employee(1013, "李飞", 28, 6000));
        list.add(new Employee(1013, "李飞", 39, 7800));
        list.add(new Employee(1013, "李飞", 40, 8000));

        list.stream().distinct().forEach(System.out::println);
    }

    //2-映射
    @Test
    public void map() {
//        map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

//        练习1：获取员工姓名长度大于3的员工的姓名。
        List<Employee> employees = Employee.getEmployees();
        employees.stream().map(Employee::getName).filter(name -> name.length() > 3).forEach(System.out::println);
        System.out.println();

        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamMiddle::fromStringToStream);

        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println("++++++++++++++++++++++");
//        flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(StreamMiddle::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str) {//aa
        List<Character> list = new ArrayList<>(str.length());
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //3-排序
    @Test
    public void sort() {
//        sorted()——自然排序
        List<Integer> list = Arrays.asList(25, 45, 36, 12, 85, 64, 72, -95, 4);
        list.stream().sorted().forEach(System.out::println);
        //抛异常，原因:Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

//        sorted(Comparator com)——定制排序

        List<Employee> employees = Employee.getEmployees();
        employees.stream().sorted((e1, e2) -> {
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0) {
                return ageValue;
            } else {
                return -Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);

        System.out.println("++++++++++++++++++");

        employees.sort(Comparator.comparing(Employee::getAge).reversed().thenComparing(Employee::getSalary, (v1, v2) -> Double.compare(v2, v1)));
        employees.forEach(System.out::println);

    }
}
