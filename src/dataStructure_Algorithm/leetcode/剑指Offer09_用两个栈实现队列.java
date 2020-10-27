package dataStructure_Algorithm.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @WebName: 剑指Offer09_用两个栈实现队列
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/11  18:37
 * “Welcome,my master”
 */
public class 剑指Offer09_用两个栈实现队列 {
    static LinkedList<Integer> A, B;


    public static void CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public static void appendTail(int value) {
        A.addLast(value);
    }

    public static int deleteHead(Stack s1, Stack s2) {
        if (!B.isEmpty()) {
            return B.removeLast();
        }
        if (A.isEmpty()) {
            return -1;
        }
        while (!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        return B.removeLast();


    }


    public static void main(String[] args) {

    }
}
