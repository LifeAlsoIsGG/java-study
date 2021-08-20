package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/30 13:01:10
 */
public class L01_两数之和 {

    //暴力法
    public static int[] twoSum(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] == target - arr[i]){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //使用hash结构
    public static int[] twoSum_2(int[] nums, int target){
        Map<Integer, Integer> integers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if(integers.containsKey(target - nums[i])){
                return new int[]{i, integers.get(target - nums[i])};
            }

            integers.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
    }
}
