package Examine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @WebName: 理解SQL
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/27  19:46
 * “Welcome,my master”
 */


public class 理解SQL {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] table = new int[n][4];
        double[][] resTable = new double[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                table[i][j] = in.nextInt();
            }
        }


        for (int i = 0; i < n; i++) {
            double age, height, weight, res, min = 0;
            for (int j = 0; j < n; j++) {
                if (table[i] != table[j]) {
                    age = Math.pow(table[i][1] - table[j][1], 2);
                    height = Math.pow(table[i][2] - table[j][2], 2);
                    weight = Math.pow(table[i][3] - table[j][3], 2);
                    min = Math.round(Math.sqrt(age + height + weight));
                    resTable[i][0] = table[i][0];
                    resTable[i][1] = table[j][0];
                    resTable[i][2] = min;
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if (table[i] != table[j]) {
                    age = Math.pow(table[i][1] - table[j][1], 2);
                    height = Math.pow(table[i][2] - table[j][2], 2);
                    weight = Math.pow(table[i][3] - table[j][3], 2);
                    res = Math.sqrt(age + height + weight);

                    if (res < 20 && res <= min) {
                        resTable[i][1] = table[j][0];
                        resTable[i][2] = res;
                        min = res;
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    System.out.printf("%.2f", resTable[i][j]);
                }
                System.out.print((int) resTable[i][j] + " ");
            }
            System.out.println();
        }

    }
}
