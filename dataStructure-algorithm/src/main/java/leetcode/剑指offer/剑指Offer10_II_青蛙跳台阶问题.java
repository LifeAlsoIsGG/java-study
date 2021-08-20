package leetcode.剑指offer;

/**
 * @WebName: 剑指Offer10_II_青蛙跳台阶问题
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/11  20:47
 * “Welcome,my master”
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class 剑指Offer10_II_青蛙跳台阶问题 {
    public static int fbi(int n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fbi(7));

    }
}
