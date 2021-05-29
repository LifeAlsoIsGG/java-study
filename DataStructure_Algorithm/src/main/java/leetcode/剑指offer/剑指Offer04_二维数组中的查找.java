package leetcode.剑指offer;

/**
 * @WebName: 剑指Offer04二维数组中的查找
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/29  16:13
 * “Welcome,my master”
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class 剑指Offer04_二维数组中的查找 {
    public static boolean findNumber() {
        int[][] nums = {
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        };
        int x = 19;
        int n = nums.length;
        int m = nums[0].length;

        boolean flag = false;
        for (int i = n - 1; i > -1; i--) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == x) {
                    flag = true;
                    break;
                }
                if (nums[i][j] > x) {
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(findNumber());
        String s = "We are happy.";
        StringBuffer stringBuffer = new StringBuffer("fuck");
        System.out.println(stringBuffer);


//        s = s.replace(" ", "%20");
        char[] chars = s.toCharArray();
        System.out.println(chars);

    }
}
