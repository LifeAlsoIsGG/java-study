package builder.builder;

import builder.model.BenzModel;
import builder.model.CarModel;
import java.util.List;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/12 0:10:55
 */
public class BenzBuilder extends CarBuilder {

    private BenzModel benz = new BenzModel();

    public CarModel getCarModel() {
        return this.benz;
    }

    public void setSequence(List<String> sequence) {
        this.benz.setSequence(sequence);
    }
}
