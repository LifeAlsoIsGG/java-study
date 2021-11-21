package proxy;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/14 15:52:48
 */
public interface IGamePlayer {

    //登录游戏
    public void login(String user, String password);

    //杀怪，网络游戏的主要特色
    public void killBoss();

}
