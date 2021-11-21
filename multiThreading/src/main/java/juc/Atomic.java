package juc;

import java.util.concurrent.atomic.*;
import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/8/28 23:18:08
 */
public class Atomic {
    private int id;

    @Test
    public void atomicIntegerTest() {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        atomicInteger.getAndIncrement();
        atomicInteger.decrementAndGet();
        atomicInteger.getAndDecrement();
        atomicInteger.get();
        atomicInteger.set(100);
        atomicInteger.accumulateAndGet(100, Integer::sum);
        System.out.println(atomicInteger);
    }

    @Test
    public void atomicBooleanTest() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.set(true);
        System.out.println(atomicBoolean);
    }

    /**
     * @description: 需要多指定下标
     **/
    @Test
    public void atomicArray() {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        atomicIntegerArray.getAndAccumulate(0, 10, (x, y) -> x * y);
        System.out.println(atomicIntegerArray);
    }

    /**
     * @description: 保证你在修改对象引用时的线程安全性, 对对象进行原子操作，一般用于自定义对象
     **/
    @Test
    public void atomicReferenceTest() {
        Object obj = new Object();
        AtomicReference<Object> atomicReference = new AtomicReference<>(obj);
        //如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。
        boolean flag = atomicReference.compareAndSet(obj, new Object());
        boolean flag2 = atomicReference.compareAndSet(new Object(), new Object());
        System.out.println(flag);
        System.out.println(flag2);
    }

    /**
     * @description: 字段更新器，解决ABA问题
     **/
    @Test
    public void test() {
        /**
         * 字段更新器：
         * AtomicReferenceFieldUpdater：基于反射的工具类，可以原子性的更新指定对象的指定应用类型字段。
         * AtomicIntegerFieldUpdater：基于反射的工具类，可以原子性的更新指定对象的指定int类型字段。
         * AtomicLongFieldUpdater：基于反射的工具类，可以原子性的更新指定对象的指定long类型字段。
         *
         * 利用字段更新器，可以针对对象的某个域（Field）进行原子操作，只能配合volatile使用，否则会出现异常
         */
        AtomicIntegerFieldUpdater<Atomic> a = AtomicIntegerFieldUpdater.newUpdater(Atomic.class, "id");

    }

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
    }
}
