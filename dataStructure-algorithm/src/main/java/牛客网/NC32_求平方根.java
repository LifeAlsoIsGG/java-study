package 牛客网;

/**
 * @WebName: NC32_求平方根
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/11  10:21
 * “Welcome,my master”
 */
public class NC32_求平方根 {

    public static int imitateSqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        for (int i = 1; i <= x; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
