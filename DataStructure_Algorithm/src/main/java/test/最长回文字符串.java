package test;

import org.apache.logging.log4j.util.Strings;

/**
 * @Package: sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/8 17:40:01
 */
public class 最长回文字符串 {

    public static String test(String s){
        //判断输入,如果小于2或者为空
        if(s.length() < 2 || s == null){
            if(Strings.isBlank(s)){
                System.out.println("空字符串");
            }else{
                System.out.println(s);
            }

            return s;
        }

        //字符串长度
        int len =s.length();

        //最大子串开始
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 1;

        //动态规划
        boolean[][] dp = new boolean[len][len];

        for (int r = 0; r < len; r++) {
            for (int l = 0; l < r; l++) {
                //如果l和r指向都相等且dp[l+1][r-1]为true
                if(s.charAt(l) == s.charAt(r) && ( r - l < 2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r - l +1 > maxLen){
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }

        System.out.println(s.substring(maxStart, maxEnd + 1));
        return s.substring(maxStart, maxEnd + 1);

    }

    public static void main(String[] args) {
        test("abbbba");
        test("aabbaa");
        test("abcabaabc");
        test(" ");
        test("a");
    }

}
