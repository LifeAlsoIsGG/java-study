package dataStructure_Algorithm.test.tencent;

import java.util.Objects;

public class hash {
    //数组初始化为100，由于动态扩容较复杂所以限制为100容量
    ListNode[] arr = new ListNode[100];

    //链表
    class ListNode {
        public int val;
        public ListNode next = null;
        public ListNode() {
        }
        public ListNode(int val) {
            this.val = val;
        }
    }

    //插入
    public Boolean put(ListNode node){
        if(node.val > arr.length){
            return false;
        }

        //简略哈希计算索引
        int index = node.val % 100;
        //判断该索引出是否为空
        if(Objects.isNull(arr[index])){
            arr[index] = node;
        }
        //冲突则拉链
        else if(!arr[index].equals(node)){
            //如果是同一个对象则不插入
            arr[index].next = node;
        }
        return true;
    }

    //查找
    public Boolean get(ListNode node){
        //如果索引插入过大
        if(node.val > arr.length){
            return null;
        }

        //简略哈希计算索引
        int index = node.val % 100;

        //判断该索引处是否存在
        if(Objects.isNull(arr[index])){
            return false;
        }

        //如果有但是不是同一个对象
        else if(!arr[index].equals(node)){
            ListNode temp = arr[index];
            while(temp != null){
                if(temp.equals(node)){
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        return true;
    }

    //删除
    public ListNode del(ListNode node){
        //如果索引插入过大
        if(node.val > arr.length){
            return null;
        }

        //简略哈希计算索引
        int index = node.val % 100;

        //判断该索引处是否存在
        if(Objects.isNull(arr[index])){
            return null;
        }

        //如果索引处是该节点就更改指向
        else if(arr[index].equals(node)){
            //让该索引处指向节点的下一个
            arr[index] = node.next;
            node.next = null;
            return node;
        }
        //如果不想等就遍历链表
        else{
            ListNode temp = arr[index];
            while(temp != null){
                if(temp.next.equals(node)){
                    temp.next = temp.next.next;
                    temp.next.next = null;
                    return temp.next;
                }
                temp = temp.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
