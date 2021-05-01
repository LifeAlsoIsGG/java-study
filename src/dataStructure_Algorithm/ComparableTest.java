package dataStructure_Algorithm;

import java.util.Arrays;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 比较器Comparable Test
 * @Datetime: 2021/5/1 22:31:14
 */

public class ComparableTest {

    static class Student implements Comparable<Student>{//指定类型为 Student
        private String name;
        private int age;
        private float score;
        public Student(String name,int age,float score){
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public String toString(){
            return name + "\t\t" + age + "\t\t" + score;
        }

        //重写该方法
        @Override
        public int compareTo(Student stu){
            //覆写 compareTo() 方法，实现排序规则的应用
            if (this.score>stu.score){
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
            }
        }
    }

    public static void main(String[] args) {
        Student[] stu = {new Student("stu1",20,90.0f),
                new Student("stu2",22,90.0f),
                new Student("stu3",20,70.0f),
                new Student("stu4",34,98)};
        Arrays.sort(stu);
        for (Student x:stu){
            System.out.println(x);
        }
    }
}

