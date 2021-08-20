package leetcode;

import java.util.*;

/**
 * @WebName: offer_3
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/16  22:14
 * “Welcome,my master”
 */
public class 找出数组中重复的数 {
    /**
     * 题解：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
     * l
     */

    public static int findRepeatNumber() {
        HashSet<Integer> dic = new HashSet<Integer>();
        int[] nums = {1, 2, 2, 4};
        int repeat = 0;
        for (int num : nums) {
            if (!dic.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public static int findRepeatNumber_2() {

        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int[] nums_2 = new int[nums.length];
        int repeat = -1;
        for (int i = 0; i < nums.length; i++) {
            if (++nums_2[nums[i]] > 1) {
                repeat = nums[i];
                break;
            }
        }
        return repeat;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber_2());

    }

}
