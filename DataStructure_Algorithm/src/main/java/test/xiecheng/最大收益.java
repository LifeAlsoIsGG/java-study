package test.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/13 19:24:38
 */
public class 最大收益 {

    static class Order {
        public int start;
        public int end;
        public int pay;
    }

    public static void sum(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        List<Order> orderList = new ArrayList<Order>(4);

        int[][] arr = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        System.out.println(arr.toString());
    }

    public static void main(String[] args) {
        sum();

    }
}
