package builder.builder;

import builder.model.CarModel;
import java.util.List;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/12 0:10:31
 */
public abstract class CarBuilder {

    //建造一个模型，你要给我一个顺序要求，就是组装顺序
    public abstract void setSequence(List<String> sequence);

    //设置完毕顺序后，就可以直接拿到这个车辆模型
    public abstract CarModel getCarModel();
}