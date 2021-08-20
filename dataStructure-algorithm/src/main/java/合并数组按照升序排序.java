import java.util.Arrays;

/**
 * @WebName: 合并数组
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/29  11:53
 * “Welcome,my master”
 */
public class 合并数组按照升序排序 {
    public static void main(String[] args) {
        Integer a[] = {1, 3, 5, 7};
        Integer b[] = {2, 4, 5, 8};
        Integer c[] = new Integer[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        System.out.println(Arrays.toString(c));

    }
}
