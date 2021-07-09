package leetcode;

import java.util.Objects;

/**
 * @WebName: Leetcode_05_最长回文子串
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/2  12:10
 * “Welcome,my master”
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class L05_最长回文子串 {

    /*暴力法，遍历所有子串*/
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindrome(chars, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static boolean validPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /*中心扩展*/
    public static String longestPalindrome_expandCenter(String s) {
        int maxLen = 0;
        int begin = 0;
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            //比较两种方式的最大值
            //当奇数个数的回文串中间有一个数时的扩展情况
            int len1 = expandAroundCenter(s, i, i);
            //当偶数个数进行扩展时
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                //赋值给索引begin
                begin = i - (len - 1) / 2;
                //赋值给回文串最大长度
                maxLen = len;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /*动态规划*/
    public static String longestPalindrome2(String s) {
        if (Objects.isNull(s) || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        //最长回文串的起点
        int maxStart = 0;
        //最长回文串的终点
        int maxEnd = 0;
        //最长回文串的长度
        int maxLen = 1;

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                //r - l <= 2 主要是判断当子串长度为3，2，1时，只用判断头尾相等即为回文字符串
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome_expandCenter("babaabd"));
        System.out.println(longestPalindrome2("babaabd"));
//        System.out.println(isPalindrome("法律律法"));

    }
}
