package designPattern.builder;

/**
 * @Project: Java-Study
 * @Package: designPattern.builder
 * @ClassName: MobikeBuilder
 * @Author: Chen Long
 * @Description: 建造者模式-MobikeBuilder
 * @Datetime: 2020/12/17  21:36
 */
// 具体 builder 类
public class MobikeBuilder extends Builder{

    @Override
    public void buildFrame() {
        bikeProduct.setFrame("MobikeFrame");
    }

    @Override
    public void buildSeat() {
        bikeProduct.setSeat("MobikeSeat");
    }

    @Override
    public void buildTire() {
        bikeProduct.setTire("MobikeTire");
    }

}



