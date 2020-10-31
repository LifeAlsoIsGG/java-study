package dataStructure_Algorithm.dataStructure.sort;

import java.util.*;

/**
 * @Project: Java-Study
 * @Package: dataStructure_Algorithm.dataStructure.sort
 * @ClassName: BucketSort
 * @Author: Chen Long
 * @Description: 桶排序
 * @Datetime: 2020/10/30  13:48
 */
public class BucketSort {

    /*用Arraylist作为桶*/
    public static void BucketSort_1(int[] arr){
        if(arr.length <= 1){
            return;
        }
        // 计算最大值与最小值
        int max = arr[0];
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        // 将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            /*计算该放在哪个桶中*/
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        // 对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        // 将桶中的元素赋值到原序列
        int index = 0;
        for (ArrayList<Integer> list : bucketArr){
            for (int val : list){
                arr[index++] = val;
            }
        }
    }


    /*用数组*/
    public static void BucketSort_2(int[] arr){
        if(arr.length <= 1){
            return;
        }
        // 计算最大值与最小值
        int max = arr[0];
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // 计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;
        int[][] bucketArr = new int[bucketNum][0];

        // 将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            /*计算该放在哪个桶中*/
            int num = (arr[i] - min) / (arr.length);
            bucketArr[num] = Arrays.copyOf(bucketArr[num], bucketArr[num].length + 1);
            bucketArr[num][bucketArr[num].length - 1] = arr[i];
        }

        // 对每个桶进行排序
        for(int i = 0; i < bucketArr.length; i++){
            Arrays.sort(bucketArr[i]);
        }

        // 将桶中的元素赋值到原序列
        int index = 0;
        for (int[] list : bucketArr){
            for (int val : list){
                arr[index++] = val;
            }
        }
    }


    public static void main(String[] args) {
        int []arr = {4,6,8,5,9};
        BucketSort_2(arr);
        System.out.println(Arrays.toString(arr));

    }
}
