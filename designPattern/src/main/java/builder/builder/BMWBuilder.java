package builder.builder;

import builder.model.BMWModel;
import builder.model.CarModel;
import java.util.List;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/12 0:12:54
 */
public class BMWBuilder extends CarBuilder {

    private BMWModel bmw = new BMWModel();

    public CarModel getCarModel() {
        return this.bmw;
    }

    public void setSequence(List<String> sequence) {
        this.bmw.setSequence(sequence);
    }
}
