package threadLocal;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/7/5 23:13:03
 */
//TODO:InheritableThreadLocal
public class ThreadLocalTest {

    static ThreadLocal<Character> stringThreadLocal = new InheritableThreadLocal<>();

    @Test
    public void main() throws InterruptedException {
        //        InheritableThreadLocal
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 26; i++) {
            int finalI = i;
            threads.add(new Thread(() -> {
                stringThreadLocal.set((char) ('a' + finalI));
                System.out.println(Thread.currentThread().getName() + "：" + stringThreadLocal.get());
            }));
        }

        //线程打印
        for (Thread t : threads) {
            t.start();
            t.join();
        }
    }
}
