import java.util.*;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/10/27 14:20:14
 */
public class Solution {
    List<List<Integer>> lists = new LinkedList<>();

    //public List<List<Integer>> findSubsequences(int[] nums) {
    //    List<List<Integer>> lists = new LinkedList<>();
    //    boolean flag1 = false;
    //    for (int i = 1; i < nums.length; ++i) {
    //        if(flag1 == (nums[i] > nums[i = 1])){
    //            continue;
    //        }
    //        flag1 = (nums[i] > nums[i - 1]);
    //    }
    //
    //    List<Integer> list = new LinkedList<>();
    //    dfs(nums, -1, list);
    //    return lists;
    //}
    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int l = low, h = high;
            int pivot = arr[low];
            while (low < high){
                //从high指针往前，遇到小于基准数时将arr[low] = arr[high]
                while (low < high && arr[high] >= pivot){
                    high--;
                }
                arr[low] = arr[high];

                //从low指针往后，遇到大于基准数时将
                while (low < high && arr[low] <= pivot){
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = pivot;
            int index = low;

            quickSort(arr, l, index - 1);
            quickSort(arr, index + 1, h);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new LinkedList<>();
        quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
        dfs(nums, -1, list);
        return lists;
    }

    private void dfs(int[] nums, int now, List<Integer> list) {
        if (list.size() > 1) {
            lists.add(new LinkedList<>(list));
        }
        Set<Integer> visited = new HashSet<>();

        for (int i = now + 1; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            if (now == -1 || nums[i] < nums[now]) {
                list.add(nums[i]);
                dfs(nums, i, list);
                list.remove(list.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{4, 1, 2, 5, 3}));
    }
}


