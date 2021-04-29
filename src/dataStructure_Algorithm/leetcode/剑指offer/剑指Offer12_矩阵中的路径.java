package dataStructure_Algorithm.leetcode.剑指offer;

/**
 * @WebName: 剑指Offer12_矩阵中的路径
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/21  20:51
 * “Welcome,my master”
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class 剑指Offer12_矩阵中的路径 {

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        /*当一维下标i越界（往下移动时）或小于0（往左移动时），或
        当二维下标j越界（往右移动时）或小于0（向上移动时），或
        board[i][j] != words[k]，不匹配时，
        返回false*/
        System.out.println("进入dfs : ");
        System.out.println("i : " + i);
        System.out.println("j : " + j);
        System.out.println("k : " + k);
        if ((i >= board.length || i < 0) || (j >= board[0].length || j < 0) || board[i][j] != words[k]) {
            return false;
        }
        /*这里也是终止条件，经过上面if后，此结点是匹配的，当此结点匹配且是字符串的最后一个元素时返回true*/
        if (k == words.length - 1) {
            return true;
        }
        /*保留字符*/
        char tmp = board[i][j];
        /*经过前面的判断，此时这个结点没越界且匹配字符串，所以将此字符串设为'/'表示遍历过*/
        board[i][j] = '/';
        /*此时往四个方向继续遍历，只要这四个方向有一个是匹配的，则说明这个结点是匹配且是连续的*/
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1)
                || dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1);

        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B',}, {'S', 'F',}};
        String word = "BS";


//        System.out.println(exist(board, word));

    }
}
