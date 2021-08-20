package 牛客网;


import java.util.Scanner;

/**
 * @WebName: 中位数
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/6  21:02
 * “Welcome,my master”
 */
public class 中位数 {

    public static void center() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr_1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr_1[i] = input.nextInt();
        }


        if (n == 2) {
            System.out.println(arr_1[1]);
            System.out.println(arr_1[0]);
        } else if (n > 2) {
            for (int i = 0; i < n; i++) {
                if (i < 3) {
                    System.out.println(arr_1[n / 2]);
                } else {
                    System.out.println(arr_1[n / 2 - 1]);
                }
            }
        }


    }

    public static void main(String[] args) {
        center();

    }
}
