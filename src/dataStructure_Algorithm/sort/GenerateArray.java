package dataStructure_Algorithm.sort;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 生成大数组
 * @Datetime: 2021/5/2 0:08:15
 */
public class GenerateArray {

    public static int[] generateArray() {
        int[] a = new int[100000];
        int i , j;
        for (i = 99999, j = 0; i >= 0; i--, j++) {
            a[j] = i;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
