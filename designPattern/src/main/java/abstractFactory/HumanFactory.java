package abstractFactory;

import abstractFactory.AbstractBlackHuman.FemaleBlackHuman;
import abstractFactory.AbstractWhiteHuman.FemaleWhiteHuman;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 抽象工厂
 * @Datetime: 2021/11/6 17:02:14
 */
public interface HumanFactory {

    //制造一个黄色人种
    Human createYellowHuman();

    //制造一个白色人种
    Human createWhiteHuman();

    //制造一个黑色人种
    Human createBlackHuman();

    class FemaleFactory implements HumanFactory {

        @Override
        public Human createYellowHuman() {
            return new FemaleBlackHuman();
        }

        @Override
        public Human createWhiteHuman() {
            return new FemaleWhiteHuman();
        }

        @Override
        public Human createBlackHuman() {
            return new FemaleBlackHuman();
        }
    }

    class MaleFactory implements HumanFactory {

        @Override
        public Human createYellowHuman() {
            return new FemaleBlackHuman();
        }

        @Override
        public Human createWhiteHuman() {
            return new FemaleWhiteHuman();
        }

        @Override
        public Human createBlackHuman() {
            return new FemaleBlackHuman();
        }
    }

}
