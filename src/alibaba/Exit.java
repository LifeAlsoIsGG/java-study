package alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: alibaba
 * @author: long chen
 * @description:
 * @datetime: 2021/4/18  19:00:27
 */
public class Exit {

    //类似经典击鼓传花
    static void println(){
        //设定人集合，当集合还剩一个人时推出
       /* List<Integer> arr = new ArrayList<>(100);
        for (int i = 1; i < 101; i++) {
            arr.add(i);
        }*/

       //总人数
       int total = 100;
       int[] num = new int[100];
       //步长
       int step = 3;
       //报数
       int flag = 0;

       //当总人数大于等于1时
       while (total >= 1){
           for (int i = 0; i < num.length; i++) {
               if(num[i] == 0){
                   //输出最后一个人
                   if(total == 1){
                       System.out.println("剩余人：" + (i+1));
                       total--;
                       break;
                   }
                   //报数自增
                   flag++;
                   //如果为3
                   if(flag == step){
                       //设置为1已淘汰
                       num[i] = 1;
                       //报数重置
                       flag = 0;
                       //总人数减一
                       total--;
                       //输出淘汰的人
                       System.out.print(i + 1 + " ");
                   }
               }
           }
       }

    }

    public static void main(String[] args) {
        println();
    }
}
