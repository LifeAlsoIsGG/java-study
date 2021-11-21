package abstractFactory;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/6 16:11:16
 */
public abstract class AbstractWhiteHuman implements Human {

    //白色人种的皮肤颜色是白色的
    public void getColor() {
        System.out.println("白色人种的皮肤颜色是白色的！");
    }

    //白色人种讲话
    public void talk() {
        System.out.println("白色人种会说话，一般说的都是单字节。");
    }

    public static class FemaleWhiteHuman extends AbstractWhiteHuman {
        public void getSex() {
            System.out.println("白人女性");
        }
    }

    public static class MaleWhiteHuman extends AbstractWhiteHuman {
        public void getSex() {
            System.out.println("白人男性");
        }
    }
}
