package test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/6/23 10:49:14
 */
public class QuickSort {

    public static void quickSort(int[] arr, int low, int high){

        if(low < high){
            int l  = low, h = high;

            //基准值
            int pivot = arr[l];

            while (low < high){

                //右指针运动
                while (low < high && arr[high] >= pivot){
                    high--;
                }

                //左指针运动
                while (low < high && arr[low] <= pivot){
                    low++;
                }

                //交换
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }

            //在交接处重新定义基准值
            arr[l] = arr[low];
            arr[low] = pivot;


            //对交界处两端重新排列
            quickSort(arr, l, low - 1);
            quickSort(arr, low + 1, h);
        }

    }

    public static void main(String[] args) {

    }
}
