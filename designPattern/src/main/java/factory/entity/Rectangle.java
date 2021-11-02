package factory.entity;

import factory.Shape;

/**
 * @author Long Chen
 * @description
 * @date 2021-08-18 20:24
 */

/*Rectangle实体类*/
public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle");
	}
}