package xiecheng;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @package: xiecheng
 * @author: long chen
 * @description:
 * @datetime: 2021/4/15  19:16:22
 */
public class BuildingHouse {

    //二叉树节点
    static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }
    }

    static String buildingHouse(String n) {
        int max = Integer.MAX_VALUE;
        int m = 0;
        //乘数
        int k = 1;
        System.out.println(n.length());
        char[] c = n.toCharArray();
        //判断是否非法
        for (int i = 0; i < c.length; i++) {
            System.out.println("m:" + m);
            //判断是不是数字
            if(c[i] < '0' || c[i] > '9'){
                return "N";
            }
            m = (m * 10) + c[i];
            System.out.println("m:" + m);
        }




        //准备构建二叉树
        List<TreeNode> houseList = new ArrayList<>();
        TreeNode node = new TreeNode("R");
        buildTree(node, m);


        //中序遍历二叉树
        StringBuilder houseStr = new StringBuilder();
        inOrderTraversal(node, houseStr);

        return new String(houseStr);

    }

    static void buildTree(TreeNode node, Integer m){
        if(m == 1){
            return;
        }
        node.left = new TreeNode("G");
        node.right = new TreeNode("R");
        buildTree(node.left, m-1);
        buildTree(node.right, m-1);
    }

    //中序遍历
    static void inOrderTraversal(TreeNode node, StringBuilder houseStr){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left, houseStr);
        houseStr.append(node.val);
        inOrderTraversal(node.right, houseStr);
    }


    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _n;
        try {
            _n = in.nextLine();
        } catch (Exception e) {
            _n = null;
        }

        res = buildingHouse(_n);
        System.out.println(res);
    }
}
