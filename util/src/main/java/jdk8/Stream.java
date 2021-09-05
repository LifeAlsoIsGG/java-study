package jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/9/5 23:43:57
 */
public class Stream {

    public static void forEach() {
        int sum;
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.parallelStream().forEach(item -> System.out.println(item));
    }

    public static void main(String[] args) {
        forEach();
    }
}
