package test;

/**
 * @WebName: 数位和计算
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/22  16:09
 * “Welcome,my master”
 */
public class 数位和计算 {
    public static void main(String[] args) {
        int i = 111111;
        String s = String.valueOf(i);
        int sum = 0;
        for (int j = 0; j < s.length(); j++) {
            sum += s.charAt(j) - '0';
        }
        System.out.println(sum);

        int j = 11111;
        int sum2 = 0;
        while (j != 0) {
            sum2 += j % 10;
            j = j / 10;
        }
        System.out.println("sum2 : " + sum2);

    }
}
