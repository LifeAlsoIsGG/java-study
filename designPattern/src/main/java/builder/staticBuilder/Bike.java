package builder.staticBuilder;

import lombok.Data;
import lombok.ToString;

/**
 * @Project: Java-Study
 * @Package: designPattern.builder
 * @ClassName: Bike
 * @Author: Chen Long
 * @Description: 建造者模式-Product
 * @Datetime: 2020/12/17  21:27
 */
@Data
@ToString
public class Bike {
    /*框架*/
    private String frame;
    /*座椅*/
    private String seat;
    /*车胎*/
    private String tire;

    public Bike() {

    }
}


