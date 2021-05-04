package dataStructure_Algorithm;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 学生对象排序
 * @Datetime: 2021/5/2 14:34:04
 */
@Data
@NoArgsConstructor
public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private float score;

    public Student(String name,int age,float score){
        this.name = name;
        this.age = age;
        this.score = score;
    }


    public static Student[] getArray(){
        return new Student[]{new Student("stu1",20,90.0f),
                new Student("stu2",22,90.0f),
                new Student("stu3",22,70.0f),
                new Student("stu4",21,60.0f),
                new Student("stu5",34,98)};
    }

    @Override
    public String toString(){
        return name + "\t\t" + age + "\t\t" + score;
    }

    //重写该方法
    @Override
    public int compareTo(Student stu){
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
