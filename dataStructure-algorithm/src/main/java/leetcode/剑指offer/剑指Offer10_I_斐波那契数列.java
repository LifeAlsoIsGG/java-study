package leetcode.剑指offer;

/**
 * @WebName: 剑指Offer10_I_斐波那契数列
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/11  20:29
 * “Welcome,my master”
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class 剑指Offer10_I_斐波那契数列 {
    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        fib(10);

    }
}
