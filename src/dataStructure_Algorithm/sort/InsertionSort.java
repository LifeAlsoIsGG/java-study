package dataStructure_Algorithm.sort;

import java.util.Arrays;

/**
 * @Project: DataStructure&Algorithm
 * @Package: dataStructure_Algorithm.sort
 * @ClassName: InsertionSort
 * @Author: Chen Long
 * @Date: 2020/10/28  0:49
 * @Description: 插入排序
 */
public class InsertionSort {
    
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                /*如果要插入的数小于排好序的最后一个数，即arr[j] < arr[j - 1]那就交换*/
                if(arr[j] < arr[j - 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
                /*否则直接退出遍历排好序数组的过程*/
                else{
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = { 4,7,6,5,3,2,8,1 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
