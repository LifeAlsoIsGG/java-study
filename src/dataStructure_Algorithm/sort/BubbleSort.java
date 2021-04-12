package dataStructure_Algorithm.sort;

import java.util.Arrays;

/**
 * @Project: DataStructure&Algorithm
 * @Package: dataStructure_Algorithm.sort
 * @ClassName: BubbleSort
 * @Author: Chen Long
 * @Date: 2020/10/21  19:48
 * @Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,10,9,11,6,20};
        /*控制比较次数*/
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            /*控制比较次数*/
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
