package dataStructure_Algorithm.leetcode;

import dataStructure_Algorithm.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @WebName: Leetcode_69_x的平方根
 * @Description: 回文链表
 * @author: Chen Long
 * @date: 2020/9/11  10:39
 */
public class L234_回文链表 {

    //1. 复制到数组中再用头尾指针向中间移动然后判断
    public Boolean isPalindrome(ListNode listNode){
        List<Integer> vals = new ArrayList<>();

        //将链表复制到数组中
        while (!Objects.isNull(listNode)){
            vals.add(listNode.val);
            listNode = listNode.next;
        }

        // 使用双指针判断是否回文
        int low = 0;
        int high = vals.size() - 1;
        while (low < high) {
            if (!vals.get(low).equals(vals.get(high))) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    //2. 使用递归遍历到最后一个时，和递归外的从头开始的指针不断比较，相当于前后比较
    public Boolean isPalindrome_recursion(ListNode listNode){
        ListNode front = listNode;
        return checkPalindrome(listNode, front);
    }

    //递归
    public Boolean checkPalindrome(ListNode listNode, ListNode front){
        if(!Objects.isNull(listNode)){
            //如果有一个不符合就不断返回false
            if(!checkPalindrome(listNode.next, front)){
                return false;
            }
            if(front.val != listNode.val){
                return false;
            }
        }
        front = front.next;
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next(new ListNode(2).next(new ListNode(3).next(new ListNode(2).next(new ListNode(1)))));
        System.out.println(new L234_回文链表().isPalindrome(head));
        System.out.println(new L234_回文链表().isPalindrome_recursion(head));
    }
}
