package factory;

import factory.entity.*;
import org.junit.Test;

/**
 * @author Long Chen
 * @description
 * @date 2021-08-18 20:25
 */

public class FactoryMain {

    @Test
    public void factoryTest() {

//        获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape_rectangle = ShapeFactory.createShape(Rectangle.class);
        shape_rectangle.draw();

        //        获取 square 的对象，并调用它的 draw 方法
        Shape shape_square = ShapeFactory.createShape(Square.class);
        shape_square.draw();

        //        获取 circle 的对象，并调用它的 draw 方法
        Shape shape_circle = ShapeFactory.createShape(Circle.class);
        shape_circle.draw();

        //结合单例模式
        Shape singletonSquare = ShapeFactory.createSingletonSquare();
        singletonSquare.draw();
    }

}
