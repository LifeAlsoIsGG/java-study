package abstractFactory;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 人种接口
 * @Datetime: 2021/11/6 16:10:19
 */
public interface Human {

    //每个人种都有相应的颜色
    void getColor();

    //人类会说话
    void talk();

    //每个人都有性别
    void getSex();
}
