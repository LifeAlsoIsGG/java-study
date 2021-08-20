package test;

import java.util.Objects;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/17 10:35:31
 */
public class cvte {

    public static int print(int[] a){
        //判断是否合格
        if(a.length == 0 || Objects.isNull(a)){
            return 0;
        }

        //记录有每遍历一个值之后最大的递增子序列数目
        int[] a1 = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            a1[i] = 1;
        }

        int sum = 0;

        //遍历，如果比前面的小，就更新到数组中
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if(a[j] < a[i]){
                    a1[i] = Math.max(a1[i], a1[j] + 1);
                }
                //比较
                sum = Math.max(sum, a1[i]);
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] a = {0,3,1,6,2,2,7};
        int[] a1 = {0,1,0,3,2,3};
        System.out.println(print(a1));

    }
}
