package junit.jMock.entity;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/10/24 17:25:46
 */
public class Driver implements IDriver {

    @Override
    public void driver(ICar car) {
        car.run();
    }
}
