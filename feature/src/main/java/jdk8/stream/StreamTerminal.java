package jdk8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import jdk8.entity.Employee;
import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: Stream终止操作
 * @Datetime: 2021/10/17 20:27:26
 */
public class StreamTerminal {

    boolean i;

    //1-匹配与查找
    @Test
    public void test() {
        List<Employee> employees = Employee.getEmployees();

//        allMatch(Predicate p)——检查是否匹配所有元素。
//          练习：是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 23);
        System.out.println(allMatch);

//        anyMatch(Predicate p)——检查是否至少匹配一个元素。
//         练习：是否存在员工的工资大于 10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 9000);
        System.out.println(anyMatch);

//        noneMatch(Predicate p)——检查是否没有匹配的元素。
//          练习：是否存在员工姓“马”
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("马"));
        System.out.println(noneMatch);

//        findFirst——返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);

//        findAny——返回当前流中的任意元素
        Optional<Employee> employee1 = employees.parallelStream().findAny();
        System.out.println(employee1);
    }

    @Test
    public void test2() {
        List<Employee> employees = Employee.getEmployees();

        // count——返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 4500).count();
        System.out.println(count);

//        max(Comparator c)——返回流中最大值
//        练习：返回最高的工资：
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> maxSalary = salaryStream.max(Double::compare);
        System.out.println(maxSalary);

//        min(Comparator c)——返回流中最小值
//        练习：返回最低工资的员工
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);
        System.out.println();

//        forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);

        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }

    //2-归约
    @Test
    public void test3() {

//经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);

        Integer v = list.parallelStream().reduce(Integer::sum).get();
        System.out.println(v);   // 300

        Integer v1 = list.parallelStream().sequential().reduce(10, Integer::sum);
        System.out.println(v1);  //310

        System.out.println("++++++++++++++++++");

        //不断地把值传递给下次处理
        Integer v2 = list.stream().reduce(0,
            //accumulator被称为累加器
            (x1, x2) -> {
                System.out.println("stream accumulator: x1:" + x1 + "  x2:" + x2);
                return x1 + x2;
            },
            //combiner被称为合成器,combiner定义的函数将accumulator提到的两个值合并起来
            (x1, x2) -> {
                System.out.println("stream combiner: x1:" + x1 + "  x2:" + x2);
                return x1 + x2;
            });
        System.out.println(v2); // 300

        System.out.println("++++++++++++++++++");

        Integer v3 = list.parallelStream().reduce(0,
            (x1, x2) -> {
                System.out.println("parallelStream accumulator: x1:" + x1 + "  x2:" + x2);
                return x1 - x2;
            },
            (x1, x2) -> {
                System.out.println("parallelStream combiner: x1:" + x1 + "  x2:" + x2);
                return x1 * x2;
            });
        System.out.println(v3); //197474048

//        reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
//        练习2：计算公司所有员工工资的总和
        List<Employee> employees = Employee.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
//        Optional<Double> sumMoney = salaryStream.reduce(Double::sum);
        Optional<Double> sumMoney = salaryStream.reduce(Double::sum);
        System.out.println(sumMoney.get());
    }

    //3-收集
    @Test
    public void test4() {
//        collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
//        练习1：查找工资大于6000的员工，结果返回为一个List或Set

        List<Employee> employees = Employee.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());

        employeeList.forEach(System.out::println);

        System.out.println("++++++++++++++++++");

        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());

        employeeSet.forEach(System.out::println);

        System.out.println("++++++++++++++++++");

        //1、key不能有重复，否则会报错，因为Map的key不能重复
        //2、value不能为空，否则报空指针
        employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
        //value可以为空
        employees.stream().collect(HashMap::new, (m, v) -> m.put(v.getId(), Function.identity()), HashMap::putAll);
    }
}
