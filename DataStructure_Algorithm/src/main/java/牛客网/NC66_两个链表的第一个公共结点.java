package 牛客网;

import dataStructure.ListNode;

/**
 * @WebName: NC66_两个链表的第一个公共结点
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/8  12:13
 * “Welcome,my master”
 */
public class NC66_两个链表的第一个公共结点 {


    /*双指针*/
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = (node1 == null) ? headB : node1.next;
            node2 = (node2 == null) ? headA : node2.next;
        }

        return node1;

    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(7);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(8);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);

        ListNode resultNode = getIntersectionNode(node1, node2);
        System.out.println(resultNode.val);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }

    }
}
