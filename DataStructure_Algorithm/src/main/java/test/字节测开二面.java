package test;

import java.util.List;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/31 17:22:01
 */
public class 字节测开二面 {

    public static int change(int i){
        int sum = 0;

        while (i != 0){
            if(i % 2 == 1){
                sum++;
            }
            i /= 2;
        }

        return sum;

    }
    
    public static void yanghui(int n){
        //二维数组
        int[][] nums = new int[n][];

        //遍历第一层
        for (int i = 0; i < nums.length; i++) {
            //每一层数量
            nums[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                //边上的1
                if(i == 0 || j ==0 || j ==i){
                    nums[i][j] = 1;
                }else{
                    nums[i][j] = nums[i - 1][j] + nums[i - 1][j - 1];
                }
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
    
    

    public static void main(String[] args) {
//        System.out.println(change(2012));
//        System.out.println(change(8));
        yanghui(5);
    }
}
