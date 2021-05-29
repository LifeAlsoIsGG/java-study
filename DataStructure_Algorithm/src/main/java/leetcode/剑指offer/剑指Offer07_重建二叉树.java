package leetcode.剑指offer;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * @WebName: 剑指Offer07_重建二叉树
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/30  12:25
 * “Welcome,my master”
 */


public class 剑指Offer07_重建二叉树 {
    static int[] preorder = {3, 9, 20, 15, 7};
    static int[] inorder = {9, 3, 15, 20, 7};
    static HashMap<Integer, Integer> map = new HashMap<>();


    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode rebuilderTree() {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);

    }

    public static TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[pre_root]);
        int in_idx = map.get(preorder[pre_root]);
        treeNode.left = recur(pre_root + 1, in_left, in_idx - 1);
        treeNode.right = recur(pre_root + (in_idx - in_left) + 1, in_idx + 1, in_right);
        return treeNode;

    }

    static ArrayList<Integer> arrayList = new ArrayList();

    public static void preOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }

        preOrder(tree.left);
        preOrder(tree.right);
        System.out.printf(tree.val + "");
        arrayList.add(tree.val);
    }


    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(3);
//        treeNode.left = new TreeNode(9);
//        treeNode.right = new TreeNode(20);
//        treeNode.right.left = new TreeNode(15);
//        treeNode.right.right = new TreeNode(7);
        TreeNode treeNode = rebuilderTree();
        preOrder(treeNode);
        System.out.println(arrayList);


    }
}


