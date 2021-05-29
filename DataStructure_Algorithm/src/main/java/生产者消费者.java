import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/5/28 14:37:26
 */
public class 生产者消费者 {

    final int MAX_SIZE = 10;
    List<Object> list = new LinkedList<>();

    //生产者
    public  void product(){
        //当总数大于最大容量
        if(list.size() > MAX_SIZE){
            System.out.println("无法生产");
        } else{
            list.add(new Object());
        }
    }


    //消费者
    public  void consume(){
        if(list.size() > 0){
            list.remove(0);
        }else{
            System.out.println("没有可以消费");
        }
    }




    public static void main(String[] args) {

    }
}
