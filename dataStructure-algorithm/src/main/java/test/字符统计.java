package test;

import java.util.*;

/**
 * @Package: sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/10 16:23:44
 */
public class 字符统计 {

    private static class ValueComparator implements Comparator<Map.Entry<Character,Integer>>
    {
        @Override
        public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
            int result = o2.getValue() - o1.getValue();
            if(result == 0){
                return o1.getKey() - o2.getKey();
            }
            return result;
        }
    }


    public static void  sort(){
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();

        Map<Character, Integer> map =  new HashMap<Character, Integer>();

        for(char c : chars){
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        List<Map.Entry<Character,Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        字符统计.ValueComparator vc = new ValueComparator();
        Collections.sort(list,vc);

        StringBuilder stringBuilder = new StringBuilder();

        for(Iterator<Map.Entry<Character,Integer>> it=list.iterator();it.hasNext();)
        {
            Character character = it.next().getKey();
            if(Character.isLetter(character) || Character.isDigit(character) || Character.isSpaceChar(character)){
                stringBuilder.append(character);
            }

        }

        System.out.println(stringBuilder);

    }


    public static void main(String[] args) {
        sort();


    }


}
