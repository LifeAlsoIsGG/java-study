package test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/6/28 19:05:04
 */
public class 妙盈编程题 {

    public static void main(String[] args) {

//         String[] versions = new String[]{"1", "2", "3", "wrong1", "wrong2"};
//        String[] versions = new String[]{ "wrong1", "wrong2"};
//         String[] versions = new String[]{"1", "2", "3", "4", "wrong1", "wrong2"};
         String[] versions = new String[]{ "1","2", "wrong1", "wrong2"};
        System.out.println(findFirstWrong(versions));
    }


    /**
     * Return The first version of code that contains bugs and is wrong.
     * @param versions total version of codes that are order by commit time.
     * @return The first wrong version of code.
     */
    public static String findFirstWrong(String[] versions) {
        int left = 0, right = versions.length - 1;
        while (left <= right){
            if(left == right){
                return versions[left];
            }
            int mid = left + (right - left) / 2;

            //如果为true，说明第一个wrong在右区间
            if(checkRight(versions[mid])){
                left = mid + 1;
            }

            //如果为false,说明第一个wrong在做区间或mid指针指向
            else{
                right = mid;
            }
        }

        return null;
    }

    /**
     * Check code which is right and contains no bugs.
     * @param version The hash of code from one commit.
     * @return True if the version of code is Right. Otherwise return False.
     */
    public static boolean checkRight(String version) {

        // Just mock some time consuming check
        doSomeTimeConsumingCheck();

        if (version.startsWith("wrong")) {
            return false;
        } else {
            return true;
        }
    }

    public static void doSomeTimeConsumingCheck() {
        try {
            Thread.sleep(1000L);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
