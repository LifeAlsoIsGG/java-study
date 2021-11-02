package junit.jMock;

import junit.jMock.entity.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/10/24 17:19:08
 */
public class DriverTest {

    Mockery mockery = new JUnit4Mockery();

    @Test
    public void driverTest() {
        final ICar car = mockery.mock(ICar.class);
        IDriver driver = new Driver();
        mockery.checking(new Expectations() {
            {
                oneOf(car).run();
            }
        });
        driver.driver(car);
    }
}
