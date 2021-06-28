package test;

import dataStructure.TreeNode;

import java.util.Stack;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/6/23 11:06:27
 */
public class TreeStack {

    public static void treeStack(TreeNode treeNode){
        Stack<TreeNode> treeNodes = new Stack<TreeNode>();

        TreeNode head = treeNode;

        //判断指针或者栈内不为空
        while (head != null || !treeNodes.isEmpty()){

            //当前指针不为空，先处理左节点
            while (head != null){
                //输出当前值
                System.out.println(head.val);
                //将当前节点存入栈中
                treeNodes.push(head);
                //将指针指向左节点
                head = head.left;
            }

            //处理右结点
            if(!treeNodes.empty()){
                //将当前节点弹出栈
                head = treeNodes.pop();
                //将指针指向右结点
                head = head.right;
            }
        }
    }

    public static void main(String[] args) {

    }
}
