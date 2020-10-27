package dataStructure_Algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @WebName: 剑指Offer06_从尾到头打印链表
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/29  22:00
 * “Welcome,my master”
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class 剑指Offer06_从尾到头打印链表 {
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    static Stack<Integer> stack = new Stack<Integer>();

    public static int[] printLinkList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        Collections.reverse(arrayList);
        int[] arr = new int[arrayList.size()];
        for (int i = arr.length - 1; i > -1; i--) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    public static int[] printLinkList_2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        addNode(head);
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;

    }

    public static void addNode(ListNode head) {
        if (head == null) {
            return;
        }
        addNode(head.next);
        arrayList.add(head.val);
    }

    public static int[] printLinkList_Stack() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] arr = new int[stack.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;

    }

    public static void main(String[] args) {
        printLinkList_Stack();
        System.out.println(stack);

    }
}


