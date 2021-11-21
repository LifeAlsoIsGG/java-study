package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/3 20:00:54
 */
public class Bianlifeng {

    //为讲师推荐最优的约课集合
    public static int solution1() {
        Scanner input = new Scanner(System.in);
        int[] arr = Arrays.stream(input.next().split(",")).mapToInt(Integer::parseInt).toArray();
        int length = arr.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return arr[0];
        }
        if (length == 2) {
            return Math.max(arr[0], arr[1]);
        }
        if (length == 3) {
            return Math.max(arr[1], arr[0] + arr[2]);
        }
        int[] sum = new int[length];
        sum[0] = 0;
        sum[1] = 1;
        sum[2] = arr[0] + arr[2];

        for (int j = 3; j < length; j++) {
            sum[j] = arr[j] + Math.max(sum[j - 2], sum[j - 3]);
        }

        return Math.max(sum[length - 1], sum[length - 2]);
    }


    public static void main(String[] args) {
        System.out.println(solution1());
    }
}
