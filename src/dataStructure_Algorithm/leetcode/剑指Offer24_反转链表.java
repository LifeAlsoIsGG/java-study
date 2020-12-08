package dataStructure_Algorithm.leetcode;

import java.util.Stack;

/**
 * @WebName: 剑指Offer24_反转链表
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/3  13:52
 * “Welcome,my master”
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/3chong-jie-jue-fang-shi-zhan-shuang-lian-biao-di-g/
 */
public class 剑指Offer24_反转链表 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int x) {
            val = x;
        }
    }

    /*第一种：使用栈*/
    public static ListNode reverseLinkList_stack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<ListNode>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode listNode_2 = stack.pop();
        ListNode listNode_3 = listNode_2;

        while (stack.size() > 0) {
            listNode_2.next = stack.pop();
            listNode_2 = listNode_2.next;
        }
        listNode_2.next = null;

        return listNode_3;
    }

    /*第二种：使用双链表，按顺序遍历链表将每个节点插入到新链表的头结点上，
    即将此结点的next指向这个新链表，
    在这之前要保留此结点在原链表的next然后继续上述操作
    */

    public static ListNode reverseLinkList_doublePointer(ListNode head) {
        ListNode listNode = null;
        while (head != null) {
            /*先保存head的next结点*/
            ListNode next = head.next;
            /*将head的next指向新链表listNode，使head成为新链表的头结点*/
            head.next = listNode;
            /*最后使新链表listNode指向head，这样listNode就包含head了，后续加入的结点会成为新链表的头结点最终完成反转*/
            listNode = head;
            /*将head指向一开始保存的head的next，开始下一步循环*/
            head = next;
        }
        return listNode;
    }

    /*第三种：递归，将结点放在反转后的链表后面并将结点的next为null
     */
    public static ListNode reverseLinkList_recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reverse = reverseLinkList_recursion(head.next);
        /*head.next为head的下一个，将head.next的下一个指回head，形成回路，同时让head指向null，这时候head就在head.next后面了*/
        head.next.next = head;
        head.next = null;
        /*返回的reverse保留着head.next,而此时head.next已经是第一个了*/
        return reverse;

    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(5);
        /*while (listNode != null ){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }*/

        ListNode listNode_2 = reverseLinkList_recursion(listNode);
        while (listNode_2 != null) {
            System.out.println(listNode_2.val);
            listNode_2 = listNode_2.next;
        }


    }
}


