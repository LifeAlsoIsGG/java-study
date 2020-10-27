package dataStructure_Algorithm.leetcode;

/**
 * @WebName: Leetcode_05_最长回文子串
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/2  12:10
 * “Welcome,my master”
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Leetcode_05_最长回文子串 {

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
            int len = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i + 1));
            if (len > maxLen) {
                begin = i - (len - 1) / 2;//赋值给索引begin
                maxLen = len;//赋值给回文串最大长度
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


    public static void main(String[] args) {
        System.out.println(longestPalindrome_expandCenter("babaabd"));
//        System.out.println(isPalindrome("法律律法"));

    }
}
