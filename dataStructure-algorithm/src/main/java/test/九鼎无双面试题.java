package test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/7/6 20:47:48
 */
public class 九鼎无双面试题 {

    public static String reverse(String str){

        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }

        return stringBuilder.toString();
    }

    public static String reverse2(String str){
        int len = str.length();
        if(len <= 1){
            return str;
        }

        String left = str.substring(0, len / 2);
        String right = str.substring(len / 2, len);
        String reverseString = reverse2(right) + reverse2(left);
        return reverseString;
    }


    public static void main(String[] args) {
//        System.out.println(reverse("abcdefg"));
        System.out.println(reverse2("abcdefg"));

        //通过异或运算推导
        int a = 10, b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(1 ^ 1);
        System.out.println(b);
    }
}
