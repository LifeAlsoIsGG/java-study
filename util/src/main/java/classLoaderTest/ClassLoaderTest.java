package classLoaderTest;

/**
 * @Project: Java-Study
 * @Package: ClassLoaderTest
 * @ClassName: ClassLoaderTest
 * @Author: v_geekrchen
 * @Description:
 * @Datetime: 2021/2/28  21:12:25
 */
public class ClassLoaderTest {


    /**
     * @return void
     * @author: long chen
     * @description 获取三种class加载器的加载路径
     * @datetime 2021/2/28 21:41:30
    */
    public static void getPath(){
        //BootstrapClassLoader加载的class
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println();

        //AppClassLoader加载的class
        System.out.println(System.getProperty("java.class.path"));
        System.out.println();

        //ExtClassLoader加载的class
        System.out.println(System.getProperty("java.class.path"));
    }


    /**
     * @return void
     * @author: long chen
     * @description 获取自己类的加载器
     * @datetime 2021/2/28 21:43:30
    */
    public static void getClassLoader(){
        ClassLoader cl = ClassLoaderTest.class.getClassLoader();

        System.out.println("ClassLoader is:" + cl.toString());

        System.out.println("ClassLoader's parent is:" + cl.getParent().toString());

        cl = int.class.getClassLoader();

        System.out.println("int.class is:" + int.class);

        //会报错Exception in thread "main" java.lang.NullPointerException
        //int.class是由Bootstrap ClassLoader加载的
//        System.out.println("ClassLoader is:" + cl.toString());


    }

    public static void main(String[] args) {
        getClassLoader();


    }
}
