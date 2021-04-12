package dataStructure_Algorithm.sort;

import java.util.Arrays;

/**
 * @Project: Java-Study
 * @Package: dataStructure_Algorithm.sort
 * @ClassName: MergeSort
 * @Author: Chen Long
 * @Date: 2020/10/28  14:01
 * @Description: 归并排序
 */
public class MergeSort {

    /*
    * 将数组拆分为两个，然后将两个各自排好序后，再合并；实现方法是使用递归不断地拆分数组然后合并有序，最后从下往上合并最后两个排好序的数组
    * */
    public static void merge(int[] arr, int low, int mid, int high) {
        /*首先定义一个辅助数组*/
        int[] helpArr = new int[high - low + 1];
        /*左指针*/
        int lPoint = low;
        /*右指针*/
        int hPoint = mid + 1;
        /*辅助指针*/
        int i = 0;
        //比较并填充辅助数组
        while (lPoint <= mid && hPoint <= high){
            if(arr[lPoint] <= arr[hPoint]){
                helpArr[i++] = arr[lPoint++];
            }else{
                helpArr[i++] = arr[hPoint++];
            }
        }
        //将剩余元素填充至辅助数组
        while (lPoint <= mid){
            helpArr[i++] = arr[lPoint++];
        }
        while (hPoint <= high){
            helpArr[i++] = arr[hPoint++];
        }
        //将辅助数组中的元素回填至原数组
        for (int j = 0; j < helpArr.length; j++) {
            arr[low + j] = helpArr[j];
        }

    }


    public static void mergeSort(int[] arr,int low,int high){
        if(arr == null || high == low){
            return ;//终止条件
        }
        //确定分割的边界
        int mid = low + (high - low) / 2;
        //对左半部分调用递归方法，使其有序
        mergeSort(arr,low,mid);
        //对右半部分调用递归方法，使其有序
        mergeSort(arr,mid + 1,high);
        //合并左右两部分，使整个数组有序
        merge(arr,low,mid,high);
    }


    public static void main(String[] args) {
        int[] arr = { 4,7,6,5,3,2,8,1 };
        //调用写好的递归版归并排序方法
        mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
