package dataStructure_Algorithm.牛客网;

import java.util.HashMap;

/**
 * @WebName: demo
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/8  12:12
 * “Welcome,my master”
 */
public class Demo {
    public static void main(String[] args) {
        HashMap<String, String> map3 = new HashMap();
        map3.put("1", "c");

        HashMap<String, String> map4 = new HashMap();
        map4.put("1", "B");
        map4.put("3", "C");


        System.out.println(map3.replace("2", "d", "b"));
        System.out.println(map3.remove("1", "c"));
        System.out.println(map3.containsKey("1"));
    }
}
