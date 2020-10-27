package test;

import java.util.Scanner;

/**
 * @WebName: 输入示例
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/21  23:59
 * “Welcome,my master”
 */
public class 输入示例 {
    static Scanner in = new Scanner(System.in);

    public static void TwoDimension_CharArray() {
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        char[][] arr = new char[m][n];

        for (int i = 0; i < m; i++) {
            String s = in.nextLine().toString();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        TwoDimension_CharArray();
        in.close();
    }
}
