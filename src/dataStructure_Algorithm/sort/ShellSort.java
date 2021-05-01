package dataStructure_Algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Project: Java-Study
 * @Package: dataStructure_Algorithm.sort
 * @ClassName: ShellSort
 * @Author: Chen Long
 * @Date: 2020/10/28  13:29
 * @Description: 希尔排序
 */
public class ShellSort {


    public static void shellSort(int[] arr){
        /*这里设置gap增量每次为上一次的/2*/
        int gap = arr.length / 2;
        while (gap > 0){
            //遍历根据步长生成的数组
            for (int i = gap; i < arr.length; i += gap) {
                //开始插入排序
                for (int j = i; j > 0; j -= gap) {
                    if(arr[j] < arr[j - gap]){
                        int tmp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = tmp;
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


    public static void main(String[] args) {
/*        for (int i = 10; i >= 0; i-=3) {
            System.out.println(i);
        }*/

        int[] arr = { 4,7,6,5,3,2,8,1 };
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
