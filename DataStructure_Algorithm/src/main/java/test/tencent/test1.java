package test.tencent;

import java.util.ArrayList;
import java.util.List;

public class test1 {

    public List<List<Integer>> print(int n){
        //当前和大于n时low++
        int low = 1;
        //当前和小于n时high++
        int high = 2;
        //当前的总和
        int sum = 0;

        //结果
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (low < high){
            sum = (low + high);

            //如果小于n
            if(sum < n){
                high ++;
            }
            //如果大于n
            else if(sum > n){
                low --;
            }
            //否则相等
            else if(sum == n){
                List<Integer> list = new ArrayList<Integer>();
                //遍历插入到结果中
                for (int i = low; i < high; i++) {
                    list.add(i);
                }
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
