import java.util.ArrayList;
import java.util.List;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/12 0:24:20
 */

public class 竞态测试 {
    static class IndexGen {
        private int index;

        int nextIndex() {
            return index++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IndexGen indexGen = new IndexGen();
        final int num = 100;
        final int[] visited = new int[num];
        final List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            threads.add(new Thread(() -> visited[indexGen.nextIndex()] ++));
        }
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%d\t", visited[i * 10 + j]);
            }
            System.out.println();
        }
    }
}