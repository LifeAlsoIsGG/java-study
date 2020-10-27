package test;

/**
 * @WebName: 多态
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/10/1  1:33
 * “Welcome,my master”
 */

class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

}

class B extends A {
    //此方法父类没有
    public String show(B obj) {
        return ("B and B");
    }

    @Override
    public String show(A obj) {
        return ("B and A");
    }
}

class C extends B {

}

class D extends B {

}


public class 多态 {

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));

    }
}
