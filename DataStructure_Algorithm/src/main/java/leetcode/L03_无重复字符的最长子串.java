package leetcode;

import java.util.*;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/24 14:42:47
 */
public class L03_无重复字符的最长子串 {


    //滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        String maxStr = "";
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            //找到上一次该字符被遍历时的下标的后一个位置，与现在的start作比较
            //如果map.get(ch)+1 < start,在窗口之前，则还是原来的start
            //如果map.get(ch)+1 = start,则说明在start的前一个，则还是start还是不变
            //如果map.get(ch)+1 > start,则说明在start的后面，那么窗口就得左边收缩到遍历到的该位置即
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1, start);
            }

            if(max < end - start + 1){
                max = end - start + 1;
                maxStr = s.substring(start, end + 1);
            }
            map.put(ch,end);
        }
        System.out.println("最长无重复字符最长子串：" + maxStr);
        return max;
    }

    //第二种方法
    public static int lengthOfLongestSubstring_2(String s) {
        int[] last = new int[128];
        Arrays.fill(last, -1);
        int start = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(last[index] + 1, start);
            max = Math.max(max, i - start + 1);
            last[index] = i;
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring_2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring_2("     "));
        System.out.println(lengthOfLongestSubstring_2("au"));
    }
}
