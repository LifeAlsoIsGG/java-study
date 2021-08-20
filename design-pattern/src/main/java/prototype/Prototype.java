package prototype;

import lombok.Data;

/**
 * @Project: Java-Study
 * @Package: designPattern.prototype
 * @ClassName: Prototype
 * @Author: Chen Long
 * @Description: 原型模式
 * @Datetime: 2020/12/22  21:17
 */
@Data
public class Prototype implements Cloneable{
    private String name;
    private Integer id;

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.setName("相同的名字");

        for (int i = 0; i < 50; i++) {
            prototype = prototype.clone();
            prototype.setId(i);
            System.out.println("prototype = " + prototype);
        }
    }
}
