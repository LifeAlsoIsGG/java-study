package junit.jMock.entity;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/10/24 17:23:34
 */


public class Car {

    static class BigCar implements ICar {

        @Override
        public void run() {
            System.out.println("大车");
        }
    }

    static class SmallCar implements ICar {

        @Override
        public void run() {
            System.out.println("小车");
        }
    }
}

