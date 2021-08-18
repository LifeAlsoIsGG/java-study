package factory;

/**
 * @author Long Chen
 * @description
 * @date 2021-08-18 20:23
 */

public class ShapeFactory{

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
