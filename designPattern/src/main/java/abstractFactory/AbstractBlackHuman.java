package abstractFactory;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/6 16:12:12
 */
public abstract class AbstractBlackHuman implements Human {

    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑色的！");
    }

    public void talk() {
        System.out.println("黑人会说话，一般人听不懂。");
    }

    public static class FemaleBlackHuman extends AbstractBlackHuman {
        public void getSex() {
            System.out.println("黑人女性");
        }
    }

    public static class MaleBlackHuman extends AbstractBlackHuman {
        public void getSex() {
            System.out.println("黑人男性");
        }
    }
}
