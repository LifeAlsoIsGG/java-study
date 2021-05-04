package dataStructure_Algorithm.sort;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 排序比较
 * @Datetime: 2021/5/2 0:17:01
 */
public class SortCompare {

    public static int[] generateArray() {
        int[] a = new int[100000];
        int i , j;
        for (i = 99999, j = 0; i >= 0; i--, j++) {
            a[j] = i;
        }
        return a;
    }

    public static void main(String[] args) {
        long start, end;


        //希尔排序
        start = System.currentTimeMillis();
        ShellSort.shellSort(generateArray());
        end = System.currentTimeMillis();
        System.out.println("希尔排序耗时：" + (end - start));

        //简单插入排序
        start = System.currentTimeMillis();
        InsertionSort.insertionSort(generateArray());
        end = System.currentTimeMillis();
        System.out.println("插入排序耗时：" + (end - start));
    }
}
