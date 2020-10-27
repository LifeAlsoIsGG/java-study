package dataStructure_Algorithm.牛客网;

import java.util.*;

/**
 * @WebName: 设计LRU缓存结构
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/31  17:48
 * “Welcome,my master”
 * https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=188&&tqId=35167&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class NC93_设计LRU缓存结构 {


    //    普通方法
    public static int[] LRU_1() {
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int k = 3;
        HashMap<Integer, Integer> map = new HashMap<>(3);

//        map.putAll();
//        Iterator ot = map.keySet().iterator();
//        ArrayList arrayList = (ArrayList) map.values();



        /*用来顺序存储被set的数据，从下标0开始往后常用值越大，当容量满时直接移除numList的第一个元素
        当set时：
            如果还有容量就调用add方法添加
            如果容量大于预定容量就remove第一个然后再添加
        当get时：
            从numList获取如果不存在返回-1
            如果存在就remove此对象并再add此对象，然后把这个对象添加到结果ArayList result中*/
        ArrayList<Integer> numList = new ArrayList<>();
        /*当get时：
            从numList获取如果不存在返回-1
            如果存在就remove此对象并再add此对象，然后把这个对象添加到ArayList result中*/
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            /*当set操作时*/
            if (operators[i][0] == 1) {
                /*注意要用Integer这样在ArrayList调用contains或remove的时候不是根据索引操作*/
                Integer key = operators[i][1];
                Integer value = operators[i][2];
                /*当map.size小于k*/
                if (map.size() < k) {
                    /*直接调用put方法*/
                    map.put(key, value);
                    /*如果numList包含此key，就移除然后再添加，这样在集合numList末尾就是最常用元素*/
                    if (numList.contains(key)) {
                        numList.remove(key);
                    }
                    numList.add(key);
                }
                /*当map.size >= k 时即已经满了*/
                else {
                    /*如果numList包含即重复添加相同的key那就移除再添加到集合numList使其变为最常用，map中不用操作*/
                    if (numList.contains(key)) {
                        /*put相同的key会覆盖value值*/
                        numList.remove(key);
                    }
                    /*如果不包含则是新元素，map中就移除此对象然后集合numList.remove第一个元素然后再添加新元素使其变为最常用*/
                    else {
                        /*numList.remove(0)后其返回值类型为移除的对象*/
                        map.remove(numList.remove(0));
                    }
                    map.put(key, value);
                    numList.add(key);
                }
            }
            /*当get操作时*/
            else if (operators[i][0] == 2) {
                Integer key = operators[i][1];

                /*如果从map中get不存在则集合result添加-1，否则添加get到的value*/
                result.add(map.get(key) == null ? -1 : map.get(key));
                /*如果numList包含此key就移除此元素再添加到末尾使其变为常用*/
                if (numList.contains(key)) {
                    numList.remove(key);
                    numList.add(key);
                }

            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }


    /*使用LinkedHashMap，使用LinkedHashMap是有顺序的key-value的map类型*/
    public static int[] LRU_2() {
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int k = 3;
        LinkedHashMap<Integer, Integer> lkmap = new LinkedHashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] opat : operators) {
            Integer key = opat[1];
            switch (opat[0]) {
                case 1:
                    Integer value = opat[2];
                    if (lkmap.size() < k) {
                        lkmap.put(key, value);
                    } else {
                        Iterator ot = lkmap.keySet().iterator();
                        lkmap.remove(ot.next());
                        lkmap.put(key, value);
                    }
                    break;

                case 2:
                    if (lkmap.containsKey(key)) {
                        Integer value_2 = lkmap.get(key);
                        result.add(value_2);
                        lkmap.remove(key);
                        lkmap.put(key, value_2);
                    } else {
                        result.add(-1);
                    }
                    break;
                default:
            }
        }
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;


    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(LRU_1()));
        System.out.println(Arrays.toString(LRU_2()));
        Integer integer = new Integer(10);
        String s = new String(String.valueOf(integer));


    }
}
