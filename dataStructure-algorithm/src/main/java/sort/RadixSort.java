package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Project: Java-Study
 * @Package: sort
 * @ClassName: RadixSort
 * @Author: Chen Long
 * @Description: 基数排序
 * @Datetime: 2020/10/30  23:44
 */
public class RadixSort {

    public static int[] RadixSort(int[] array) {
        if (array == null) {
            return null;
        }

        int maxLength = maxLength(array);

        return sortCore(array, 0, maxLength);
    }

    public static int[] sortCore(int[] array, int digit, int maxLength) {
        if (digit >= maxLength) {
            return array;
        }

        final int radix = 10; // 基数
        int arrayLength = array.length;
        int[] count = new int[radix];
        int[] bucket = new int[arrayLength];

        // 统计将数组中的数字分配到桶中后，各个桶中的数字个数
        for (int i = 0; i < arrayLength; i++) {
            count[getDigit(array[i], digit)]++;
        }

        // 将各个桶中的数字个数，转化成各个桶中最后一个数字的下标索引
        for (int i = 1; i < radix; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // 将原数组中的数字分配给辅助数组 bucket
        for (int i = arrayLength - 1; i >= 0; i--) {
            int number = array[i];
            int d = getDigit(number, digit);
            bucket[count[d] - 1] = number;
            count[d]--;
        }

        return sortCore(bucket, digit + 1, maxLength);
    }

    /*
     * 一个数组中最大数字的位数
     */

    public static int maxLength(int[] array) {
        int maxLength = 0;
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            int currentLength = length(array[i]);
            if (maxLength < currentLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }

    /*
     * 计算一个数字共有多少位
     */
    public static int length(int number) {
        return String.valueOf(number).length();
    }

    /*
     * 获取 x 这个数的 d 位数上的数字
     * 比如获取 123 的 0 位数,结果返回 3
     */
    public static int getDigit(int x, int d) {
        int a[] = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
        return ((x / a[d]) % 10);
    }


    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 9; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("排序前：" + Arrays.toString(arr));
        RadixSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));

    }
}
