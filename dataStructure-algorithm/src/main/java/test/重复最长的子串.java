package test;

import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/6/4 14:32:00
 */
public class 重复最长的子串 {

    public static String test(String str){

        if(Strings.isBlank(str)){
            return null;
        }

        int max = 0, curMax = 0 , start = 0, end = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            char ch1 = str.charAt(i + 1);
            //如果后一个字符不等于当前的
            if(ch != ch1){
                if(curMax > max){
                    end = i;
                    start = end - curMax + 1;
                    max = curMax;
                }
            }else {
                if(i == str.length() - 1){
                    curMax += 2;
                }
                curMax ++;
            }
        }

        return str.substring(start, end + 1);
    }







    public static void main(String[] args) {
        System.out.println(test(null));
        System.out.println(test(""));
        System.out.println(test("aaaabb"));
        System.out.println(test("aaabbb"));
        System.out.println(test("aaabbbccc"));
        System.out.println(test("abcd"));
    }
}
