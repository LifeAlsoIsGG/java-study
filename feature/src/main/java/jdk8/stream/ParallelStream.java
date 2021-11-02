package jdk8.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 并行流
 * @Datetime: 2021/10/19 1:04:42
 */
public class ParallelStream {

    private static final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);


    @Test
    public void parallelSum() {
        //整体并行还是串行主要看最后一次调用的方式
        // 生成自然数无限流
        int sum = Stream.iterate(1, i -> i + 1)
            // 限制到前n个数
            .limit(10)
            // 将流转为并行流
            .parallel()
            //重新转换为串行流
            .sequential()
            // 对所有数字求和来归纳流
            .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    public static long measurePerf(Supplier<Long> adder) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            Instant start = Instant.now();
            adder.get();
            Instant end = Instant.now();
            long duration = (Duration.between(start, end).toNanos()) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }


    //iterate 生成的是装箱的对象，必须拆箱成数字才能求和，且在并行时需要依赖于之前的结果使得开销更大
    @Test
    public void durationPrint() {
        long n = 10_000_000;
        //Sequential sum done in:94 msecs
        System.out.println("Sequential sum done in:" + measurePerf(() -> Stream.iterate(1L, i -> i + 1)
            .limit(n)
            .reduce(0L, Long::sum)) + " msecs");

        //Parallel sum done in:78 msecs
        System.out.println("Parallel sum done in:" + measurePerf(() -> Stream.iterate(1L, i -> i + 1)
            .limit(n)
            .parallel()
            .reduce(0L, Long::sum)) + " msecs");

        //Iterative sum done in:5 msecs
        System.out.println("Iterative sum done in:" + measurePerf(() -> {
            long result = 0;
            for (long i = 0; i <= n; i++) {
                result += i;
            }
            return result;
        }) + " msecs");

        //Ranged sum done in:5 msecs
        //数值流避免了非针对性流那些没必要的自动装箱和拆箱操作。
        System.out.println("Ranged sum done in:" + measurePerf(() -> LongStream.rangeClosed(1, n)
            .reduce(0L, Long::sum)) + " msecs");
        //Ranged sum done in:5 msecs

        //Ranged and parallel sum done in:2 msecs
        //range加parallel使得性能最大化
        System.out.println("Ranged and parallel sum done in:" + measurePerf(() -> LongStream.rangeClosed(1, n)
            .parallel()
            .reduce(0L, Long::sum)) + " msecs");

    }

    @Test
    public void forEach() {
        list.stream().unordered().parallel().forEach(System.out::println);
        System.out.println("++++++++++++++++++");
        list.parallelStream().forEach(System.out::println);
        System.out.println("++++++++++++++++++");
        list.parallelStream().forEachOrdered(System.out::println);
    }


    @Test
    public void reduce() {

        //不断地把值传递给下次处理
        Integer v2 = list.stream().reduce(0,
            //accumulator被称为累加器
            (x1, x2) -> {
                System.out.println("stream accumulator: x1:" + x1 + "  x2:" + x2);
                return x1 - x2;
            },
            //combiner被称为合成器,combiner定义的函数将accumulator提到的两个值合并起来
            (x1, x2) -> {
                System.out.println("stream combiner: x1:" + x1 + "  x2:" + x2);
                return x1 * x2;
            });
        System.out.println(v2); // 300

        System.out.println("++++++++++++++++++");

        /**
         *         累加器部分（水平向右）
         *         accumulator
         *             -----------------------------›
         *         thread-1:   1 * 1 * 2   =   2    |    合并器方向（竖直向下）
         *         thread-2:   1 * 2 * 2   =   4    |         combiner
         *         thread-3:   1 * 3 * 2   =   6    |   因此最终的答案是2  *  4  *  6  =   48（没毛病）
         *         ˇ
         *         注：水平方向最前面的1就是identity的值
         **/
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
    }
}
