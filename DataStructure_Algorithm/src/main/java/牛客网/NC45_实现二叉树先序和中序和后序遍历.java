package 牛客网;

import java.util.ArrayList;

/**
 * @WebName: NC45_实现二叉树先序和中序和后序遍历
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/5  13:01
 * “Welcome,my master”
 * https://www.nowcoder.com/practice/a9fec6c46a684ad5a3abd4e365a9d362?tpId=188&&tqId=35172&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class NC45_实现二叉树先序和中序和后序遍历 {
    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int x) {
            val = x;
        }
    }

    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();

    public static int[][] threeOrders(TreeNode root) {
        for (int i = 0; i < 3; i++) {
            arrayList.add(new ArrayList<Integer>());
        }

        preOrder(root);
        inOrder(root);
        afterOrder(root);

        int size = arrayList.get(0).size();

        int[][] array = new int[3][size];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = arrayList.get(i).get(j);
            }
        }

        return array;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        arrayList.get(0).add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        arrayList.get(1).add(root.val);
        inOrder(root.right);
    }

    public static void afterOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        arrayList.get(2).add(root.val);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
//        arrayList.add(new ArrayList<Integer>());
//        preOrder(treeNode);
//        inOrder(treeNode);
//        System.out.println(threeOrders(treeNode).toString());
        threeOrders(treeNode);
        System.out.println(arrayList);

    }
}
