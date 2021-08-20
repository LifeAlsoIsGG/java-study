package sort;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/13 19:37:05
 */
@Data
@NoArgsConstructor
public class Students implements Comparable<Students>{
    private String name;
    private int age;
    private float score;

    public Students(String name, int age, float score){
        this.name = name;
        this.age = age;
        this.score = score;
    }


    public static Students[] getArray(){
        return new Students[]{new Students("stu1",20,90.0f),
                new Students("stu2",22,90.0f),
                new Students("stu3",22,70.0f),
                new Students("stu4",21,60.0f),
                new Students("stu5",34,98)};
    }

    @Override
    public String toString(){
        return name + "\t\t" + age + "\t\t" + score;
    }

    //重写该方法
    @Override
    public int compareTo(Students stu){
        int result = (int) (this.score - stu.score);
        //如果想等则比较年龄
        if(result == 0){
            return result = this.age - stu.age;
        }
        return result;
        //覆写 compareTo() 方法，实现排序规则的应用
/*        if (this.score>stu.score){
            return 1;
        }else if(this.score < stu.score){
            return -1;
        }else {
            if (this.age > stu.age){
                return 1;
            }else if (this.age<stu.age){
                return -1;
            }else {
                return 0;
            }
        }*/
    }
}

