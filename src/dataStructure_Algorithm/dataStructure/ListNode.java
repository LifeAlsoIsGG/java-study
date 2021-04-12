package dataStructure_Algorithm.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @package: dataStructure_Algorithm.dataStructure
 * @author: long chen
 * @description: 链表节点
 * @datetime: 2021/3/28  15:38:58
 */

@Builder(toBuilder = true)
@AllArgsConstructor
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode next(ListNode node){
        this.next = node;
        return this;
    }

    public static ListNode getNode(){
        ListNode head = new ListNode(1);
        return head.next(new ListNode(2).next(new ListNode(3).next(new ListNode(4).next(new ListNode(5)))));
    }



}
