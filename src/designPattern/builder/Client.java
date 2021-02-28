package designPattern.builder;

/**
 * @Project: Java-Study
 * @Package: designPattern.builder
 * @ClassName: Client
 * @Author: Chen Long
 * @Description: 建造者模式-Client
 * @Datetime: 2020/12/17  21:54
 */
public class Client {
    public static void main(String[] args) {

        //根据Ofo建造者创建Mobike实体类
        Director MobikeDirector = new Director(new MobikeBuilder());
        Bike MobikeBike = MobikeDirector.construct();
        System.out.println("MobikeBike = " + MobikeBike.toString());

        //根据Ofo建造者创建Ofo实体类
        Director OfoDirector = new Director(new OfoBuilder());
        Bike OfoBike = OfoDirector.construct();
        System.out.println("OfoBike = " + OfoBike.toString());


        /*测试使用静态内部类Build的build()方法来创建bike*/
        BikeWithBuild bikeWithBuild = BikeWithBuild.builder()
                .frame("frame")
                .build();

        System.out.println("bikeWithBuild = " + bikeWithBuild);
        BikeWithBuild bikeWithBuild1 = new BikeWithBuild();

    }

}
