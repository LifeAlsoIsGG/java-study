package threadLocal;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/13 22:20:54
 */
public class InheritableThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();


    public static void main(String[] args) {
        threadLocal.set("mainThread");
        inheritableThreadLocal.set("mainThread");
        System.out.println("threadLocal value:" + threadLocal.get());
        System.out.println("inheritableThreadLocal value:" + inheritableThreadLocal.get());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //在main下的该子线程无法继承父线程的值
                System.out.println("threadLocal value:" + threadLocal.get());
                //inheritableThreadLocal可以
                //这里相当于复制了，如果父子线程改变了值不会互相影响
                System.out.println("inheritableThreadLocal value:" + inheritableThreadLocal.get());
            }
        });
        thread.start();
    }
}
