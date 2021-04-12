package dataStructure_Algorithm.sort;

import java.util.Arrays;

/**
 * @Project: DataStructure&Algorithm
 * @Package: dataStructure_Algorithm.sort
 * @ClassName: Quick_Sort
 * @Author: Chen Long
 * @Date: 2020/10/27  18:43
 * @Description: 快速排序
 * - https://www.runoob.com/w3cnote/quick-sort-2.html
 * - https://www.runoob.com/w3cnote/quick-sort.html
 * - https://blog.csdn.net/nrsc272420199/article/details/82587933
 * - https://www.sohu.com/a/246785807_684445
 */
public class QuickSort {

    /*挖坑加分治*/
    public static void quickSort_1(int[] arr, int low, int high){
        if(low < high){
            int l = low, h = high;
            int pivot = arr[low];
            while (low < high){
                //从high指针往前，遇到小于基准数时将arr[low] = arr[high]
                while (low < high && arr[high] >= pivot){
                    high--;
                }
                arr[low] = arr[high];

                //从low指针往后，遇到大于基准数时将
                while (low < high && arr[low] <= pivot){
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = pivot;
            int index = low;

            quickSort_1(arr, l, index - 1);
            quickSort_1(arr, index + 1, h);
        }
    }

    /*指针交换法*/
    public static void quickSort_2(int[] arr, int low, int high){
        if(low < high){
            int l = low, h = high;
            int pivot = arr[l];
            while (low < high){
                //从high指针往前，遇到小于基准数时将arr[low] = arr[high]
                while (low < high && arr[high] >= pivot){
                    high--;
                }
                //从low指针往后，遇到大于基准数时将
                while (low < high && arr[low] <= pivot){
                    low++;
                }
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
            arr[l] = arr[low];
            arr[low] = pivot;
            quickSort_2(arr, l, low - 1);
            quickSort_2(arr, low + 1, h);
        }
    }



    public static void main(String[] args) {
        int[] arr = { 4,7,6,5,3,2,8,1 };
        quickSort_2(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));

    }
}
