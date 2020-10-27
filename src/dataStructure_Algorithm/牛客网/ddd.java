package dataStructure_Algorithm.牛客网;

/**
 * @WebName: ddd
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/10  11:30
 * “Welcome,my master”
 */
public class ddd {
    public static void main(String[] args) {
        Person p = new Person("阿大");
        change(p);
        System.out.println(p.name);
    }

    public static void change(Person p) {
        Person person = new Person("阿小");
        p = person;
    }
}

class Person {
    static String name;

    public Person(String name) {
        this.name = name;
    }
}
