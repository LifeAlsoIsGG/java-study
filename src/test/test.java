package test;

/**
 * @WebName:
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/11  11:06
 */
public class test {
    static class MyClass {

        void changeValue(StringBuffer buffer) {
            buffer.append("world");
        }
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        StringBuffer buffer = new StringBuffer("hello");
        myClass.changeValue(buffer);
        System.out.println(buffer.toString());


        /*String s3 = new StringBuffer("11").toString();
        String s5 = s3.intern();
        String s4 = "11";
        System.out.println(s5 == s3);
        System.out.println(s5 == s4);
        System.out.println(s3 == s4);

        System.out.println("======================");

        String s6 = new String("go") +new String("od");
        String s7 = s6.intern();
        String s8 = "good";
        System.out.println(s6 == s7);
        System.out.println(s7 == s8);
        System.out.println(s6 == s8);*/

        /*String s1 = "Hello";
        String s2 = new StringBuffer("Hello").toString();
        String s3 = s2.intern();
        System.out.println("s1 == s2? " + (s1 == s2));
        System.out.println("s1 == s3? " + (s1 == s3));
        System.out.println();*/

        /*String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);*/

        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        String s7 = s3 + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s7);

        String str2 = new String("str") + new String("01");
        String str1 = "str01";

        System.out.println(str2.intern() == str1);

        String fuck = "";
        System.out.println("fuck : " + fuck);


    }
}



