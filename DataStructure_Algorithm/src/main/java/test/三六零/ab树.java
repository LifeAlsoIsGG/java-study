package test.三六零;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/6/3 15:39:53
 */
public class ab树 {

    /*
    * 小明得到一个只包含a,b两个字符的字符串，但是小明不希望在这个字符串里a出现在b左边。
    * 现在他可以将”ab”这样的子串替换成”bba”，在原串中的相对位置不变。输出小明最少需要操作多少次才能让一个给定字符串所有a都在b的右边。
    * */

    public static void abTree(String str, int num){
        int oldNum = num;
        char[] chars = str.toCharArray();
        String[] strs = new String[str.length()];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(chars[i]);
        }

        for (int i = 0; i < strs.length; i++) {
            if(!strs.equals("a") && !strs.equals("b")){
                return;
            }
        }


        end:
        for (int i = 0; i < strs.length - 1; i++) {
            if(strs[i].equals("a") && strs[i + 1].equals("b")){
                strs[i] = "bb";
                strs[i + 1] = "a";
                num ++;
                break end;
            }
        }

        List<String> stringList = new ArrayList<>();
        for (String s : strs){
            if(s.equals("bb")){
                stringList.add("b");
                stringList.add("b");
            }else{
                stringList.add(s);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stringList){
            stringBuilder.append(s);
        }

        if(oldNum == num){
            System.out.println(num);
        }else{
            abTree(stringBuilder.toString(), num);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        abTree(str, 0);
    }
}
