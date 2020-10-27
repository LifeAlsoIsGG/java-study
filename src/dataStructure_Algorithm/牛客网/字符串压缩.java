package dataStructure_Algorithm.牛客网;


import java.util.Collections;
import java.util.Scanner;

/**
 * @WebName: 字符串压缩
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/31  9:16
 * “Welcome,my master”
 * https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=188&&tqId=35167&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class 字符串压缩 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = "HG[3|B[2|CA]]F";
        StringBuilder stringBuilder = new StringBuilder();
        while (words.contains("]")) {
            int right = words.indexOf("]");
            int left = words.lastIndexOf("[", right);
            String repeatStr = words.substring(left + 1, right);
            String[] split = repeatStr.split("\\|");
            stringBuilder = new StringBuilder();
            for (int i = 0; i < Integer.parseInt(split[0]); i++) {
                stringBuilder.append(split[1]);
            }

            words = words.replace(words.substring(left, right + 1), String.join("", Collections.nCopies(Integer.parseInt(split[0]), split[1])));
//            words = words.replace(words.substring(left, right+1), stringBuilder.toString());
        }

        System.out.println(words);

    }
}
