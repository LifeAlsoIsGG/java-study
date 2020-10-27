package dataStructure_Algorithm;

import java.util.HashSet;

/**
 * @WebName: 移除相同的数字
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/30  22:07
 * “Welcome,my master”
 */
public class 移除相同的数字 {


    public static void main(String[] args) {
        String string = "1,2,2,3,4,4";
        string.concat("xx");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fuck");
        String[] strings = string.split(",");
        HashSet<Integer> hashSet = new HashSet();
        int num = 0;
        for (int i = 0; i < strings.length; i++) {
            if (hashSet.add(Integer.parseInt(strings[i]))) {
                num++;
            }
        }
        System.out.println(num);

    }
}
