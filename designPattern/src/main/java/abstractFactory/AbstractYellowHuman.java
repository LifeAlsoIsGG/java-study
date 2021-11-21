package abstractFactory;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/6 16:58:17
 */
public abstract class AbstractYellowHuman implements Human {

    public void getColor() {
        System.out.println("黄色人种的皮肤颜色是黄色的！");
    }

    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节。");
    }

    public static class FemaleYellowHuman extends AbstractYellowHuman {

        //黄人女性
        public void getSex() {
            System.out.println("黄人女性");
        }
    }

    public static class MaleYellowHuman extends AbstractYellowHuman {

        //黄人女性
        public void getSex() {
            System.out.println("黄人男性");
        }
    }
}
