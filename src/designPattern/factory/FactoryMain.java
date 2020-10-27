package designPattern.factory;

import java.util.Arrays;

/**
 * @Project: DataStructure&Algorithm
 * @Package: designPattern.factory
 * @ClassName: Factory
 * @Author: Chen Long
 * @Date: 2020/10/20  13:05
 * @Description: 工厂模式:https://www.runoob.com/design-pattern/factory-pattern.html
 */

/*创建shape接口*/
interface Shape {
    public void draw();
}

/*Rectangle实体类*/
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}

/*Rectangle实体类，结合单例模式静态内部类*/
/*class Rectangle extends Shape{
    private Rectangle(){

    }

    private static class SingletonInstance{
        private static final Rectangle INSTANCE = new Rectangle();
    }

    public static Rectangle getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}*/

/*Rectangle实体类，结合单例模式枚举*/
/*enum Rectangle implements Shape{
    INSTANCE;

    @Override
    public void draw() {
        System.out.println("枚举");
    }
}*/


/*Square实体类*/
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square");
    }
}

/*Circle实体类*/
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

/*创建工厂类用来创建返回不同的对象*/
/*class ShapeFactory{

    public static Shape getShape(String shape){
        if (shape == null){
            return null;
        }else if(shape.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }else if(shape.equalsIgnoreCase("square")){
            return new Square();
        }else if(shape.equalsIgnoreCase("circle")){
            return new Circle();
        }
        return null;
    }
}*/

/*使用反射创建工厂类用来创建返回不同的对象*/
class ShapeFactory{

    public static <T extends Shape> T getShape(Class<T> clz){
        T t = null;
        try {
            t = (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;

    }
}



public class FactoryMain {
    public static void main(String[] args) {
        /*创建工厂对象*/
        ShapeFactory shapeFactory = new ShapeFactory();

//        获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape_rectangle = ShapeFactory.getShape(Rectangle.class);
        shape_rectangle.draw();

        //        获取 square 的对象，并调用它的 draw 方法
        Shape shape_square = ShapeFactory.getShape(Square.class);
        shape_square.draw();

        //        获取 circle 的对象，并调用它的 draw 方法
        Shape shape_circle = ShapeFactory.getShape(Circle.class);
        shape_circle.draw();

        int[] a = {1,2,3};
        int[] b = Arrays.copyOf(a, 10);
        System.out.println(Arrays.toString(b));

    }
}

