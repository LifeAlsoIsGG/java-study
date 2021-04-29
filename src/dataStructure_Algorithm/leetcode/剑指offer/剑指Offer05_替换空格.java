package dataStructure_Algorithm.leetcode.剑指offer;

/**
 * @WebName: 剑指Offer05_替换空格
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/29  21:41
 * “Welcome,my master”
 */
public class 剑指Offer05_替换空格 {
    public static String replaceSpace() {
        String s = "We are happy.";
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
            s = stringBuilder.toString();

        }
        return s;
    }

    public static void main(String[] args) {

    }
}
