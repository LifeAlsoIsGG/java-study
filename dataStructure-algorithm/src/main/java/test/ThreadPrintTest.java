package test;

import lombok.val;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/6/28 19:34:32
 */
public class ThreadPrintTest {

    static volatile boolean flag;
    static volatile Integer number = 1;

    //打印数字
    public void numberPrint(){

        //如果为true说明该字母打印
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print(number++);
        flag = true;
        notifyAll();
    }


    //打印字母
    public void letterPrint(){
        //如果为false说明该数字打印
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print((char)('a' + (number - 2)));
        flag = false;
        notifyAll();
    }

    public static void main(String[] args) {
        ThreadPrintTest threadPrintTest = new ThreadPrintTest();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                threadPrintTest.numberPrint();
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                threadPrintTest.letterPrint();
            }
        }).start();
    }
}
