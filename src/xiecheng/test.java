package xiecheng;

/**
 * @package: xiecheng
 * @author: long chen
 * @description:
 * @datetime: 2021/4/15  20:53:49
 */
public class test {
    public static void main(String[] args) {

        int max = Integer.MAX_VALUE;

        //乘数
        int k = 1;
        //判断是否非法
        String n = "3131";
        int m = 0;
        for (int i = 0; i < n.length(); i++) {
            //判断是不是数字

            System.out.println("n.charAt(i):" + n.charAt(i));
            m = m + n.charAt(i);
            System.out.println("n:" + n);
        }
        System.out.println(m);


    }
}
