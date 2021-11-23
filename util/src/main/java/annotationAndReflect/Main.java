package annotationAndReflect;

import annotationAndReflect.annotation.Table;
import annotationAndReflect.annotation.TableField;
import annotationAndReflect.entity.ReflectEntity;
import annotationAndReflect.entity.Student;
import com.google.common.collect.Lists;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.*;
import java.util.*;
import org.junit.Test;

/**
 * @Package: annotationAndrReflect
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/23 18:46:44
 */
public class Main {

    //反射操作注解
    @Test
    public void annotationTest() throws NoSuchFieldException {
        Class clz = Student.class;
        //获取类上注解的标记的value值
        Annotation[] declaredAnnotations = clz.getDeclaredAnnotations();
        Table table = (Table) clz.getAnnotation(Table.class);
        System.out.println(table.value());

        //获取字段上的
        Field id = clz.getDeclaredField("id");
        TableField annotation = (TableField) id.getAnnotation(TableField.class);
        System.out.println(annotation);
    }

    @Test
    public void allClassTest() {
        List<Class> classList = Lists.newArrayList();
        classList.add(Object.class);//类
        classList.add(Comparable.class);//接口
        classList.add(String[].class);//数组
        classList.add(int[].class);//不同类型数组
        classList.add(int[][].class);//不同维度数组
        classList.add(Override.class);//注解
        classList.add(ElementType.class);//枚举
        classList.add(Integer.class);//包装类型
        classList.add(void.class);//void
        classList.add(Class.class);//Class
        classList.forEach(System.out::println);
    }


    @Test
    public void reflectTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Main reflectTest = new Main();
        //三种获取Class,获取的都是单例的class对象
        Class clz_1 = Main.class;
        Class clz_2 = reflectTest.getClass();
        Class clz_3 = Class.forName("annotationAndReflect.Main");
        //创建实例
        Main entity = (Main) clz_1.newInstance();
        //特殊获取
        System.out.println(Integer.TYPE);//int
        System.out.println(clz_1.equals(clz_2));        //true
        System.out.println(clz_1.equals(clz_3));        //true
        System.out.println(clz_2.equals(clz_3));        //true
        System.out.println(clz_1.getName());//annotationAndReflect.ReflectTest
        System.out.println(clz_1.getSimpleName());//ReflectTest
        System.out.println(clz_1.getClassLoader());
        System.out.println(clz_1.getSuperclass());//class java.lang.Object
        System.out.println(Object.class.getSuperclass());//null

        //获取方法
        //获取构造器
    }

    //获取构造器
    @Test
    public void getConstruct() throws Exception {
        Class<?> clz = ReflectEntity.class;
        Constructor<?>[] declaredConstructors = clz.getDeclaredConstructors();
        Arrays.stream(declaredConstructors).forEach(System.out::println);
        Constructor constructor = clz.getDeclaredConstructor(int.class, String.class, ReflectEntity.class);
        //private方法设为可访问
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance(1, "Draco", new ReflectEntity()));
    }

    //获取属性
    @Test
    public void getFieldTest() throws NoSuchFieldException, IllegalAccessException {
        Class<?> clz = ReflectEntity.class;
        //获取公共
        Field[] fields = clz.getFields();
        //获取所有
        fields = clz.getDeclaredFields();
        Arrays.stream(fields).forEach(item -> {
            System.out.println(item.getName());
        });
        ReflectEntity reflectEntity = new ReflectEntity();
        Field field = clz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(reflectEntity, "Draco");
        System.out.println(reflectEntity);

    }

    @Test
    public void getMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectEntity reflectEntity = new ReflectEntity();
        Class<?> clz = ReflectEntity.class;
        //获取公共
        Method[] methods = clz.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
        //通过invoke去调用
        clz.getDeclaredMethod("setName", String.class).invoke(reflectEntity, "Draco");
        System.out.println(clz.getDeclaredMethod("getName").invoke(reflectEntity));//Draco
    }

    //泛型方法获取
    @Test
    public void genericsTest() throws NoSuchMethodException {
        Class<?> clz = ReflectEntity.class;
        Method method = clz.getDeclaredMethod("generics", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Arrays.stream(genericParameterTypes).forEach(item -> {
            System.out.println(item);
            //如果是一个参数化类型
            if (item instanceof ParameterizedType) {
                //获得真实类型
                Type[] actualTypeArguments = ((ParameterizedType) item).getActualTypeArguments();
                Arrays.stream(actualTypeArguments).forEach(System.out::println);
            }
        });

        method = clz.getDeclaredMethod("generics");
        Type genericReturnType = method.getGenericReturnType();
        System.out.println(genericReturnType);
        if (genericReturnType instanceof ParameterizedType) {
            //获得真实类型
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            Arrays.stream(actualTypeArguments).forEach(System.out::println);
        }
    }

}
