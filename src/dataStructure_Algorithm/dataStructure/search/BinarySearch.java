package dataStructure_Algorithm.dataStructure.search;

/**
 * @WebName: BianrySearch
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/9/12  9:50
 * “Welcome,my master”
 * https://www.cnblogs.com/kyoner/p/11080078.html
 */
public class BinarySearch {

    /*基本二分查找框架*/
    public static int binarySearch(int[] nums, int target) {
        System.out.println("基本二分查找框架");
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("mid : " + mid);
            System.out.println("nums[mid] : " + nums[mid]);
            System.out.println("left : " + left);
            System.out.println("right : " + right);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /*查询最左侧索引*/
    public static int binarySearch_Left(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            /*当相等时，并不是直接返回，而是收紧右侧区间在mid的前一个*/
            if (target == nums[mid]) {
                right = mid - 1;
            }
            /*当target > nums[mid]时收紧左侧区间，即left = mid + 1*/
            else if (target > nums[mid]) {
                left = mid + 1;
            }
            /*当target < nums[mid]时收紧右侧区间，即right = mid - 1*/
            else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return left;
    }

    /*查询最右侧索引*/
    public static int binarySearch_Right(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        System.out.println("nums.length : " + nums.length);

        while (left <= right) {
            System.out.println("left : " + left);
            System.out.println("right : " + right);
            int mid = left + (right - left) / 2;
            /*当相等时，并不是直接返回，而是收紧左侧区间在mid的后一个，以此查找是否右边还有此值*/
            if (target == nums[mid]) {
                left = mid + 1;
            }
            /*当target > nums[mid]时收紧左侧区间，即left = mid + 1*/
            else if (target > nums[mid]) {
                left = mid + 1;
            }
            /*当target < nums[mid]时收紧右侧区间，即right = mid - 1*/
            else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 10; i < 20; i++) {
            arr[i - 10] = i;
        }

        int[] arr_2 = {4, 4, 4, 4, 4, 5, 5, 5, 5};

        System.out.println(binarySearch_Left(arr_2, 5));

    }
}
