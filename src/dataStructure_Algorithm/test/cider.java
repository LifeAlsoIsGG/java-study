package dataStructure_Algorithm.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/8 17:17:16
 */
public class cider implements Comparable<cider> {
    private String order;

    @Override
    public int compareTo(cider o) {
        String str[] = this.order.split("-");
        String str1[] = o.order.split("-");

        //如果当前的首字母大于比较的字母
        if (str[0].charAt(0) > str1[0].charAt(0)) {
            return 1;
        }
        //如果等于，就判断数字大小
        else if(str[0].charAt(0) == str1[0].charAt(0)){
            Integer i = Integer.parseInt(str[0].substring(1, str[0].length()));
            Integer j = Integer.parseInt(str1[0].substring(1, str[0].length()));
            if(i > j){
                return -1;
            }else if(i == j){

            }
        }
        return -1;
    }



    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("M04-002-001");
        list.add("M3-602-001");
        list.add("M104-003-001");
        list.add("M103-002-11");
        list.add("M18-002-001");
        list.add("J01-002-001");
        list.add("A101-052-001");
    }


}
