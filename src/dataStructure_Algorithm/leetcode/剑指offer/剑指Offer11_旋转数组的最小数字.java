package dataStructure_Algorithm.leetcode.剑指offer;

/**
 * @WebName: 剑指Offer11_旋转数组的最小数字
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/20  13:47
 * “Welcome,my master”
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class 剑指Offer11_旋转数组的最小数字 {
    /**
     *
     */

    public static int findMin(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int left = 0, right = numbers.length - 1, mid;
        /*整体思路使用二分法*/
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] == numbers[right]) {
                right -= 1;
            }
        }
        return numbers[left];

    }

    public static void main(String[] args) {
        int[] numbers = {3, 5, 5, 1, 2};
        System.out.println("findMin(numbers) : " + findMin(numbers));

    }
}
