package designPattern.builder;

/**
 * @Project: Java-Study
 * @Package: designPattern.builder
 * @ClassName: Director
 * @Author: Chen Long
 * @Description: 建造者模式-Director
 * @Datetime: 2020/12/17  21:50
 */
public class Director {
    private Builder builder;

    // 方式一：通过构造函数设置实际的构造者
    // 传入类型是基类，面向抽象编程，符合里氏替换原则
    public Director(Builder builder) {
        this.builder = builder;
    }

    // 方式二：通过setter方法设置实际的构造者
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    // 构建复杂产品对象
    public Bike construct() {
        builder.buildTire();
        builder.buildFrame();
        builder.buildSeat();
        return builder.getProduct();
    }
}

