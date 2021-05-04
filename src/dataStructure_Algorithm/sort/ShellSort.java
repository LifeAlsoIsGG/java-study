package dataStructure_Algorithm.sort;

import dataStructure_Algorithm.Student;

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


    public static void shellSort(int[] a){
        /*这里设置gap增量每次为上一次的/2*/
        int N = a.length;
        //希尔增量
        for(int h = N / 2; h > 0; h /= 2){
            for(int i = h; i < N; i++){
                //将a[i]插入到a[i-h],a[i-2h],a[i-3h]...中
                for(int j = i; j >= h && a[j] < a[j - h]; j -= h){
                    int temp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = temp;
                }
            }
        }
/*        int gap = arr.length / 2;
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
                    *//*否则直接退出遍历排好序数组的过程*//*
                    else{
                        break;
                    }
                }
            }
            gap = gap / 2;
        }*/
    }

    //对象排序
    public static void shellSort(Student[] a) {
        /*这里设置gap增量每次为上一次的/2*/
        int N = a.length;
        //希尔增量
        for (int h = N / 2; h > 0; h /= 2) {
            for (int i = h; i < N; i++) {
                //将a[i]插入到a[i-h],a[i-2h],a[i-3h]...中
                for (int j = i; j >= h && a[j].compareTo(a[j - h]) < 0; j -= h) {
                    Student temp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
/*        for (int i = 10; i >= 0; i-=3) {
            System.out.println(i);
        }*/

        int[] arr = { 4,7,6,5,3,2,8,1 };
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

        Student[] students = Student.getArray();
        shellSort(students);
        for (Student x : students){
            System.out.println(x);
        }

    }
}
