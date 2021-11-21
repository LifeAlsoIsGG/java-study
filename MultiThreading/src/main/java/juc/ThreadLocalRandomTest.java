package juc;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/8/28 23:20:04
 * 参考：https://www.cnblogs.com/54chensongxia/p/12294994.html
 */
public class ThreadLocalRandomTest {
    @Test
    public void test(){
        //Random的局限性并不是线程安全的问题，而是在大量线程并发的时候，
        //通过CAS机制更新随机数种子会导致大量线程自旋，耗费CPU性能，导致系统吞吐量下降。
        System.out.println(new Random().nextInt());
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        System.out.println(threadLocalRandom.nextInt());
    }

}
