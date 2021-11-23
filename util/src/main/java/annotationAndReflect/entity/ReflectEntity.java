package annotationAndReflect.entity;

import java.util.*;
import lombok.Data;

/**
 * @Package: reflect
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/22 20:27:05
 */
@Data
public class ReflectEntity {

    private int id;
    private String name;
    private ReflectEntity reflectEntity;

    public ReflectEntity() {
    }

    public ReflectEntity(int id, String name, ReflectEntity reflectEntity) {
        this.id = id;
        this.name = name;
        this.reflectEntity = reflectEntity;
    }

    public void generics(Map<String, String> map, List<String> list) {
        System.out.println("泛型方法");
    }

    public Map<String, String> generics() {
        System.out.println("泛型方法2");
        return new HashMap<>();
    }


}
