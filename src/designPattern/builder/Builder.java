package designPattern.builder;

/**
 * @Project: Java-Study
 * @Package: designPattern.builder
 * @ClassName: Builder
 * @Author: Chen Long
 * @Description: 建造者模式-Builder抽象类
 * @Datetime: 2020/12/17  21:35
 */

public abstract class Builder {
    // 创建产品对象
    protected  Bike bikeProduct = new Bike();

    // 具体部件建造过程在具体Builder中实现
    abstract void buildFrame();
    abstract void buildSeat();
    abstract void buildTire();

    // 定义工厂方法，返回一个完整产品对象
    public Bike getProduct(){
        return bikeProduct;
    }
}

