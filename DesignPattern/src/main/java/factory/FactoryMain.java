package factory;

import java.util.Arrays;

/**
 * @author Long Chen
 * @description
 * @date 2021-08-18 20:25
 */

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
