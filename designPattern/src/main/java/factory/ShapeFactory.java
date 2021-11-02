package factory;

import factory.entity.*;

/**
 * @author Long Chen
 * @description
 * @date 2021-08-18 20:23
 */

public class ShapeFactory {

    //只有继承Shape接口的类的参数类才能接收
    public static <T extends Shape> T createShape(Class<T> clz) {
        Shape shape = null;
        try {
            shape = (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("创建错误");
        }
        return (T) shape;
    }

    //定义多个不用参数的创建方法
    public static Shape createCircle() {
        return createShape(Circle.class);
    }

    public static Shape createRectangle() {
        return createShape(Rectangle.class);
    }

    public static Shape createSquare() {
        return createShape(Square.class);
    }
}
