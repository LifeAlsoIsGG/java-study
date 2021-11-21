package prototype;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.junit.Test;

/**
 * @Project: Java-Study
 * @Package: designPattern.prototype
 * @ClassName: Prototype
 * @Author: Chen Long
 * @Description: 原型模式
 * @Datetime: 2020/12/22  21:17
 */
@Data
//Cloneable仅仅标记可Clone无实际接口方法，如果不声明会报CloneNotSupportedException，效果和实现Serial接口一样
public class Prototype implements Cloneable {

    private String name;
    private Integer id;

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    @Test
    public void test() throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.setName("相同的名字");

        List<Prototype> prototypes = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            prototype = prototype.clone();
            prototype.setId(i);
            prototypes.add(prototype);
        }
        prototypes.forEach(System.out::println);
    }
}
