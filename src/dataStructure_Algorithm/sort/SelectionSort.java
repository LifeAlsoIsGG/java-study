package dataStructure_Algorithm.sort;

import java.util.Arrays;

/**
 * @Project: DataStructure&Algorithm
 * @Package: dataStructure_Algorithm.sort
 * @ClassName: SelectionSort
 * @Author: Chen Long
 * @Date: 2020/10/27  22:56
 * @Description: 选择排序
 */
public class SelectionSort {

    public static void SelectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4,7,6,5,3,2,8,1 };
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
