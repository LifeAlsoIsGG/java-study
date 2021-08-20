package leetcode;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/30 17:08:05
 */
public class L103_二叉树的锯齿形层序遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        zigzagLevelOrder(lists, root, 0);
        return lists;
    }

    public void zigzagLevelOrder(List<List<Integer>> lists, TreeNode node, int floor){
        if(Objects.isNull(node)){
            return ;
        }
        //传递过来floor（从0开始）值等于链表个数（层数）时，说明是还未开始遍历的层，就新添加一个链表
        //否则，说明已经创建好该层的链表，直接插入即可
        //这里不能用小于等于，因为进入左节点后增加一个链表后，同层的右结点的floor小于size会又创建一个链表
        if(floor == lists.size()){
            lists.add(new LinkedList<>());
        }

        //使用链表来添加每层的元素
        LinkedList<Integer> subList = (LinkedList<Integer>) lists.get(floor);

        //从层数0开始，如果奇数层（从右往左遍历）则该层每个元素使用头插法，如果是偶数层则相反
        if(floor % 2  == 1){
            subList.addFirst(node.val);
        }else {
            subList.addLast(node.val);
        }

        //递归继续遍历左节点
        zigzagLevelOrder(lists, node.left, floor + 1);
        //递归继续遍历右结点
        zigzagLevelOrder(lists, node.right, floor + 1);
    }

    public static void main(String[] args) {

    }
}
