package builder;

import org.junit.Test;

/**
 * @Project: Java-Study
 * @Package: designPattern.builder
 * @ClassName: Client
 * @Author: Chen Long
 * @Description: 建造者模式-Client
 * @Datetime: 2020/12/17  21:54
 */
public class Client {

    @Test
    public void clientTest() {
        Director director = new Director();
//1万辆A类型的奔驰车
        for (int i = 0; i < 10000; i++) {
            director.getABenzModel().run();
        }
//100万辆B类型的奔驰车
        for (int i = 0; i < 1000000; i++) {
            director.getBBenzModel().run();
        }
//1000万辆C类型的宝马车
        for (int i = 0; i < 10000000; i++) {
            director.getCBMWModel().run();
        }
    }
}
