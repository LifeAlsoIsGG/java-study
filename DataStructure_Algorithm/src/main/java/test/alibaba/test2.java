package test.alibaba;

import java.util.*;

/**
 * @package: test.alibaba
 * @author: long chen
 * @description:
 * @datetime: 2021/4/18  19:18:58
 */
public class test2 {

    static List<List<String>> println(String[] source){
        //判断非法
        if(Objects.isNull(source) || source.length == 0){
            return null;
        }
        //通过set唯一性来判断同一批字符串
        Map<String, List<String>> hashMap = new HashMap<>(source.length);
        //遍历字符串数组,进行两次遍历
        for (String str : source){
            //转换为字符数组
            char[] c = str.toCharArray();
            //排序
            Arrays.sort(c);
            //排序后再比较
            String sortStr = String.valueOf(c);

            //如果是新的就新创建一个字符串数组元素
            if(!hashMap.containsKey(sortStr)){
                hashMap.put(sortStr, new ArrayList<>());
            }
            //最后添加到同字符相等中
            hashMap.get(sortStr).add(str);
        }
        List<List<String>> result = new ArrayList<>(hashMap.values());
        return result;
    }


    public static void main(String[] args) {
        String[] source ={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(println(source));

    }
}
