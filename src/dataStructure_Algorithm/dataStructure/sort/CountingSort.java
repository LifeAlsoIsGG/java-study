package dataStructure_Algorithm.dataStructure.sort;

import java.util.Arrays;

/**
 * @Project: Java-Study
 * @Package: dataStructure_Algorithm.dataStructure.sort
 * @ClassName: CountingSort
 * @Author: Chen Long
 * @Description: 计数排序
 * @Datetime: 2020/10/29  23:31
 */
public class CountingSort {
    public static void CountingSort(int[] arr) {
        int max = arr[0];
        /*获取最大值*/
        for(int val : arr){
            max = Math.max(val, max);
        }
        /*新建计数数组，长度为arr中最大值max*/
        int[] helpArr = new int[max + 1];
        for(int val : arr){
            helpArr[val]++;
        }
        /*重新填回原数组*/
        int index = 0;
        for (int i = 0; i < helpArr.length; i++) {
            if(helpArr[i] == 0){
                continue;
            }
            for (int j = 0; j < helpArr[i]; j++) {
                arr[index+j] = i;
            }
            index+=helpArr[i];
        }
    }
    public static void main(String[] args) {
        int []arr = {4,6,8,5,9};
        CountingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
