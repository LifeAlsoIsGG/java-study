package builder.staticBuilder;


import lombok.ToString;
import org.junit.Test;

/**
 * @Project: Java-Study
 * @Package: designPattern.builder
 * @ClassName: BikeWithBuild
 * @Author: Chen Long
 * @Description: 利用内部build类来创建实体类，适合多参数且不确定时
 * @Datetime: 2020/12/17  23:33
 */
@ToString
public class BikeWithBuilder {

    /*框架*/
    private String frame;
    /*座椅*/
    private String seat;
    /*车胎*/
    private String tire;

    public BikeWithBuilder() {
    }

    // 构造方法范围设为private意味着只能通过内部即内部的Builder来创建对象
    private BikeWithBuilder(Builder builder) {
        frame = builder.frame;
        seat = builder.seat;
        tire = builder.tire;
    }

    //设为静态，当类BikeWithBuild调用此静态方法后即BikeWithBuild.builder()返回Builder实体，
    //即可以开始调用属性方法来构造，最后用Builder的build()返回实体类完成构造
    public static BikeWithBuilder.Builder builder() {
        return new BikeWithBuilder.Builder();
    }


    // 静态内部类Builder
    public static final class Builder {

        /*框架*/
        private String frame;
        /*座椅*/
        private String seat;
        /*车胎*/
        private String tire;

        // 空的构造方法
        public Builder() {
        }

        public BikeWithBuilder.Builder frame(String frame) {
            this.frame = frame;
            return this;
        }

        public BikeWithBuilder.Builder seat(String seat) {
            this.seat = seat;
            return this;
        }

        public BikeWithBuilder.Builder tire(String tire) {
            this.tire = tire;
            return this;
        }

        //最后调用build将想要的属性赋值后的Builder作为参数来返回BikeWithBuild对象
        public BikeWithBuilder build() {
            return new BikeWithBuilder(this);
        }
    }

    @Test
    public void builderTest() {
        /*测试使用静态内部类Build的build()方法来创建bike*/
        BikeWithBuilder bikeWithBuilder = BikeWithBuilder.builder()
            .frame("frame")
            .build();

        System.out.println("bikeWithBuild = " + bikeWithBuilder);
    }
}

