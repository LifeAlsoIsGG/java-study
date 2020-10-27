package dataStructure_Algorithm.牛客网;

import java.util.ArrayList;

/**
 * @WebName: xxx
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/31  20:38
 * “Welcome,my master”
 */
public class xxx {
    public static ArrayList<String> main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < values.get(0).size(); i++) {
            for (int k = 0; k < values.get(1).size(); k++) {
                if (values.get(0).get(i).equals(values.get(1).get(i))) {
                    arrayList.add(values.get(0).get(i));
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        } else if (values.size() == 2) {
            if (arrayList.size() == 0) {
                return null;
            } else {
                return arrayList;
            }
        } else {
            for (int i = 2; i < values.size(); i++) {
                for (int j = 0; j < arrayList.size(); j++) {
                    if (!values.get(i).contains(arrayList.get(j))) {
                        arrayList.remove(j);
                    }
                }
            }
            return arrayList;
        }

/*        return null;

        int a;
        int b ;
        for (int i = 0; i < 501; i++) {
            if((Math.sqrt(i+a) * Math.sqrt(i+a) == i+a && Math.sqrt(i+b) * Math.sqrt(i+b) == i+b)){
                return i;
            }
        }*/

    }
}
