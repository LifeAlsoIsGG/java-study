package test.三六零;

import dataStructure.TreeNode;

import java.util.Objects;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 判断哈夫曼树是否对称
 * @Datetime: 2021/6/3 14:19:15
 */
public class 判断是否对称二叉树 {

    public static boolean test(TreeNode root){

        if(Objects.isNull(root)){
            return true;
        }

        return test(root.left, root.right);
    }

    public static boolean test(TreeNode left, TreeNode right){

        //当左右节点都为null时返回空
        if(Objects.isNull(left) && Objects.isNull(right)){
            return true;
        }

        //当某个节点为空返回false
        if(Objects.isNull(left) || Objects.isNull(right)){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return test(left.left, right.right) && test(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
