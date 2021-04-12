package dataStructure_Algorithm.sort;

import java.util.Arrays;

/**
 * @Project: Java-Study
 * @Package: dataStructure_Algorithm.sort
 * @ClassName: HeapSort
 * @Author: Chen Long
 * @Description: 堆排序
 * @Datetime: 2020/10/29  14:00
 * https://blog.csdn.net/qq_36186690/article/details/82505569
 */
public class HeapSort {

    public static void HeapSort(int []arr){
        //1.构建大顶堆
        for(int i = (arr.length / 2 - 1); i >= 0; i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j = arr.length - 1; j > 0; j--){
            //将堆顶元素与末尾元素进行交换
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            //因为首元素和末尾元素调换，不满足最大堆需要重新调整为大顶堆。
            //重新对堆进行调整,每次传入的j--作为堆的length即对除了末尾元素的堆重新调整将最大值调整在最上面
            adjustHeap(arr, 0, j);
        }

    }

    public static void adjustHeap(int[] arr, int i, int length){
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for(int k = (i * 2 + 1); k < length ; k = (k * 2 + 1)){
            //如果左子结点小于右子结点，k指向右子结点，k + 1是指当前左节点的兄弟节点右结点
            if(k + 1 < length && arr[k] < arr[k + 1]){
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] > temp){
                arr[i] = arr[k];
                //让i指向替换的值的下标，如果下一次循环的左右结点大于temp
                //就直接继续覆盖i指向下标的值
                //循环结束后，再将temp值赋给它被交换后在的位置，也就是i指向的位置
                i = k;
            }else{
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }


    
    public static void main(String[] args) {
        int []arr = {4,6,8,5,9};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
