package dataStructure_Algorithm.牛客网;


import dataStructure_Algorithm.dataStructure.ListNode;

import java.util.*;

/**
 * @package: dataStructure_Algorithm.牛客网
 * @author: long chen
 * @description:
 * @datetime: 2021/3/28  16:21:40
 */
public class NC4_判断链表中是否有环 {


    /*
    * 第一种使用快慢指针，如果有环，则一定会相遇。每次一行动他们之间的距离就会减1
    * */
    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }


    //第二种：使用HashSet运用去重的逻辑
    public static Boolean hastSetMethod(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            //如果重复出现说明有环
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {
        //回环
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);

        head.next(head2.next(head3.next(head4.next(head2))));


//        System.out.println(hasCycle(head));

        System.out.println(hastSetMethod(head));
    }
}
