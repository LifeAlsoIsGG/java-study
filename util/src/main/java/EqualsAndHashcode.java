/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 重写equals和hashcode示例
 * @Datetime: 2021/8/29 22:43:53
 */
public class EqualsAndHashcode {

    static class Student{
        //当学生的姓名、年龄、性别相等时，认为学生对象是相等的，不一定需要对象地址完全相同
        private String name;// 姓名
        private String sex;// 性别
        private String age;// 年龄
        private float weight;// 体重
        private String address;// 地址

        // 重写equals方法
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Student) {
                // instanceof 已经处理了obj = null的情况
                Student stuObj = (Student) obj;
                // 地址相等
                if (this == stuObj) {
                    return true;
                }
                // 如果两个对象姓名、年龄、性别相等，我们认为两个对象相等
                if (stuObj.name.equals(this.name) && stuObj.sex.equals(this.sex) && stuObj.age.equals(this.age)) {
                    return true;
                }
            }
            return false;
        }

        // 重写hashcode方法
        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    public static void main(String[] args) {

    }
}
