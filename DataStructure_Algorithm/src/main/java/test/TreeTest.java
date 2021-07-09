package test;

import dataStructure.ListNode;
import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 妙盈编程题
 * @Datetime: 2021/6/29 11:07:29
 */
public class TreeTest {

    //递归反转二叉树
    public static TreeNode treeReserve(TreeNode root){
        if(Objects.isNull(root)){
            return root;
        }

        TreeNode temp = root.left;
        root.left = treeReserve(root.right);
        root.right = treeReserve(temp);

        return root;
    }

    //数组 -> 二叉树 [1, 2, 3, 4, 5, 6, 7] ->
    public static TreeNode arrToTree(int[] arr, int index){

        if(index >= arr.length){
            return null;
        }

        TreeNode root = null;
        int value = arr[index];
        root = new TreeNode(value);

        root.left = arrToTree(arr, 2 * index + 1);
        root.right = arrToTree(arr, 2 * index + 2);


        return root;
    }

    //二叉树转数组
    public static void treeToArr(TreeNode root){

        if(Objects.isNull(root)){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.val);
            if(!Objects.isNull(treeNode.left)){
                queue.offer(treeNode.left);
            }

            if(!Objects.isNull(treeNode.right)){
                queue.offer(treeNode.right);
            }
        }
    }

    public static void main(String[] args) {
        //数组构建二叉树
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("构建二叉树");
        TreeNode treeNode = arrToTree(arr, 0);
        System.out.println(treeNode);



        //反转二叉树
        System.out.println("反转二叉树");
        System.out.println(treeReserve(treeNode));


        //层序遍历
        System.out.println("层序遍历");
        treeToArr(treeNode);

    }
}
