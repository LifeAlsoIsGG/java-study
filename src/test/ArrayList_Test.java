package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @WebName: ArrayList_Test
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/29  22:46
 * “Welcome,my master”
 */

abstract class Animal {

    public Animal() {
    }

    //动物名字
    String name;

    //动物叫声
    public void shout() {
        System.out.println("叫声...");
    }
}

class Dog extends Animal {
    //狗类独有的方法
    public void guard() {
        System.out.println("狗有看门的独特本领！");
    }
}

public class ArrayList_Test {
    public static void main(String[] args) {
/*        Animal a1 = new Animal();
        Animal a2 = new Dog();*/

        List arr = new ArrayList();
        boolean flag = true;
        Integer i = 1;
        arr.add(flag);
        arr.add(i);
        for (int j = 0; j < arr.size(); j++) {
            System.out.println(arr.get(j).getClass());
        }
    }
}
