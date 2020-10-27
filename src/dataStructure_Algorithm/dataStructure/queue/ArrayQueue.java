package dataStructure_Algorithm.dataStructure.queue;

import java.util.Scanner;

/**
 * @WebName: ArrayQueue
 * @Description: TODO
 * @author: Chen Long
 * @date: 2020/8/16  16:35
 * “Welcome,my master”
 */
public class ArrayQueue {
    private int maxSize;// 表示数组最大容量
    private int front; // 队列头指针指向队列头的前一个位置
    private int rear; // 队列尾指针
    private int[] arrQueue; // 该数据用于存放数据，模拟队列

    //        创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arrQueue = new int[maxSize];
        front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置，当队列执行出操作时++
        rear = -1; // 向队列队尾，指向队列尾的数据(队列最后一个数据)，当队列执行入操作时++
    }

    //        判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //        判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //        入队操作
    public void addQueue(int n) {
        //        判断队列是否满
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        arrQueue[rear] = n;
    }

    //        出队操作
    public int outQueue() {
        //        判断队列是否满
        if (isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        front++;
        return arrQueue[front];
    }

    //    查看未出队的数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front + 1; i < rear + 1; i++) {
            System.out.printf("arr[%d] = %d\n", i, arrQueue[i]);
        }
    }

    //    显示队列的头数据，并不是取出操作
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arrQueue[front + 1];
    }

    public static void main(String[] args) {
//        构造数组队列
        ArrayQueue arrayQueue = new ArrayQueue(2);
        char input;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println();
            System.out.println("a(add)：入队");
            System.out.println("g(get)：出队");
            System.out.println("s(show)：显示队列");
            System.out.println("h(head)：查看队列头数据");
            System.out.println("e(exit)：退出程序");

            input = scanner.next().charAt(0);
            switch (input) {

                //输出队列
                case 's':
                    arrayQueue.showQueue();
                    break;

                //入队操作
                case 'a':
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;

                //出队操作
                case 'g':
                    try {
                        System.out.println("出队的数据为 = " + arrayQueue.outQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //输出队列头数据
                case 'h':
                    try {
                        System.out.println("队列的头数据为 = " + arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //退出
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;
            }
        }

    }
}


