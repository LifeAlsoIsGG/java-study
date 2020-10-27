package dataStructure_Algorithm.leetcode;

/**
 * @WebName: Leetcode_69_x的平方根
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/11  10:39
 * “Welcome,my master”
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Leetcode_69_x的平方根 {
    public static int imitateSqrt_1(int x) {

        if (x <= 0) {
            return 0;
        }
        for (int i = 1; i <= x; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                return i;
            }
        }
        return 0;
    }


    public static int imitateSqrt_2(int x) {
        if (x == 0) {
            return 0;
        }
        System.out.printf("log(%.3f) 为 %.3f%n", Math.E, Math.log(Math.E));
        System.out.println("Math.log(x) : " + Math.log(x));
        System.out.println("Math.exp(0.5 * Math.log(x) : " + Math.exp(0.5 * Math.log(x)));
        int ans = (int) Math.exp(0.5 * Math.log(x));
        System.out.println("ans : " + ans);
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public static int binarySearch(int x) {
        if (x <= 0) {
            return 0;
        }
        int left = 1, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(8));


    }
}
