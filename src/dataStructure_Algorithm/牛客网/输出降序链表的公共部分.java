package dataStructure_Algorithm.牛客网;

import java.util.*;

/**
 * @WebName: 输出降序链表的公共部分
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/6  20:07
 * “Welcome,my master”
 */
public class 输出降序链表的公共部分 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int[] publicNum() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> arrList_1 = new ArrayList<>();
        ArrayList<Integer> arrList_2 = new ArrayList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        ListNode listNode_1 = null;
        ListNode listNode_2 = null;


        int n = input.nextInt();
        int[] arr_1 = new int[n];
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            arrList_1.add(x);
            listNode_1 = new ListNode(x);
            listNode_1 = listNode_1.next;
        }


        int m = input.nextInt();
        int[] arr_2 = new int[m];
        for (int i = 0; i < m; i++) {
            int x = input.nextInt();
            arrList_2.add(x);
            listNode_2 = new ListNode(x);
            listNode_2 = listNode_2.next;
        }

        for (int i = 0; i < n; i++) {
            if (arrList_2.contains(arrList_1.get(i))) {
                resultList.add(arrList_1.get(i));
            }
        }

        /*int k = 0,j = 0;
        while (k < n && j < m){
            if(arr_1[k] == arr_1[j]){
                arrList.add(arr_1[k]);
                k++;
                j++;
            }else if(arr_1[k] < arr_1[j]){
                k++;
            }else if(arr_1[k] > arr_1[j]){
                j++;
            }
        */
        Collections.sort(resultList);
        Collections.reverse(resultList);
        System.out.println(resultList);
        int[] resultArr = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
            System.out.print(resultArr[i] + " ");
        }


        input.close();

        return resultArr;
    }

    public static void main(String[] args) {
        publicNum();


    }
}
