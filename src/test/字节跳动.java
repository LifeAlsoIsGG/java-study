package test;

import java.util.Scanner;

/**
 * @WebName: 字节跳动
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/20  19:28
 * “Welcome,my master”
 */
public class 字节跳动 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0) {
            n--;
            int x = in.nextInt();
            int y = in.nextInt();
            char z = in.next().charAt(0);

            switch (z) {
                case '+':
                    System.out.println((x + y) % 1000000007);
                    break;
                case '-':
                    System.out.println((x - y) % 1000000007);
                    break;
                case '*':
                    System.out.println((x * y) % 1000000007);
                    break;
                case '^':
                    System.out.println(Math.pow(x, y) % 1000000007);
                    break;
                default:
                    break;
            }
        }
    }
}
