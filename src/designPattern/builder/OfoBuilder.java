package designPattern.builder;

/**
 * @Project: Java-Study
 * @Package: designPattern.builder
 * @ClassName: OfoBuilder
 * @Author: Chen Long
 * @Description: 建造者模式-OfoBuilder
 * @Datetime: 2020/12/17  21:49
 */
public class OfoBuilder extends Builder{

    @Override
    public void buildFrame() {
        bikeProduct.setFrame("OfoFrame");
    }

    @Override
    public void buildSeat() {
        bikeProduct.setSeat("OfoSeat");
    }

    @Override
    public void buildTire() {
        bikeProduct.setTire("OfoTire");
    }

}