package dataStructure_Algorithm.dataStructure.sort;

import java.util.Arrays;

/**
 * @Project: Java-Study
 * @Package: dataStructure_Algorithm.dataStructure.sort
 * @ClassName: ShellSort
 * @Author: Chen Long
 * @Date: 2020/10/28  13:29
 * @Description: 希尔排序
 */
public class ShellSort {


    public static void ShellSort(int[] arr){
        /*这里设置gap增量每次为上一次的/2*/
        int gap = arr.length / 2;
        while (gap > 0){
            for (int i = gap; i < arr.length; i+=gap) {
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
            gap = gap / 2;
        }
    }


    /**
     * @MethodName 
     * @Params 
     * @Return 
     * @Description TODO
     * @Datetime 2020/10/28 15:45
     */
    int a(int b, String s, int[] t){
        return 10;
    }

    public static void main(String[] args) {
        int[] arr = { 4,7,6,5,3,2,8,1 };
        ShellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
