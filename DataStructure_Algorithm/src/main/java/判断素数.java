/**
 * @WebName: 判断素数
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/9  0:45
 * “Welcome,my master”
 */
public class 判断素数 {
    public static boolean primeNumber(int i) {
        int s = (int) Math.sqrt(i);
        int j = 0;
        for (j = 2; j <= s; j++) {
            if (i % j == 0) {
                break;
            }
        }
        if (j > s) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(primeNumber(19));

    }
}
