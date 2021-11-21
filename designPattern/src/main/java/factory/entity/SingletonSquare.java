package factory.entity;

import factory.Shape;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/6 0:11:13
 */
public class SingletonSquare implements Shape {

    private SingletonSquare() {

    }

    private static class SingletonSquareInstance {

        private static final SingletonSquare INSTANCE = new SingletonSquare();
    }

    public static SingletonSquare getInstance() {
        return SingletonSquareInstance.INSTANCE;
    }

    @Override
    public void draw() {
        System.out.println("SingletonSquare");
    }

}
