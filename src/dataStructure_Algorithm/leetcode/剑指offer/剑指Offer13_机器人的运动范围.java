package dataStructure_Algorithm.leetcode.剑指offer;

/**
 * @WebName: 剑指Offer13_机器人的运动范围
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/22  14:46
 * “Welcome,my master”
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class 剑指Offer13_机器人的运动范围 {
    int m;
    int n;
    int k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0);
    }

    public int dfs(int i, int j) {
        if (i >= m || j >= n || getSum(i) + getSum(j) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }

    /*获取数位和*/
    public static int getSum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new 剑指Offer13_机器人的运动范围().movingCount(100, 100, 35));

    }
}
