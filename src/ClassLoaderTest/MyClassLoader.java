package ClassLoaderTest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @package: ClassLoaderTest
 * @author: long chen
 * @description:
 * @datetime: 2021/2/28  23:32:08
 */
public class MyClassLoader extends ClassLoader{
    private String libPath;

    public MyClassLoader(String libPath) {
        // TODO Auto-generated constructor stub
        this.libPath = libPath;
    }


/*    *//**
     * @param name:
     * @return java.lang.Class<?>
     * @author: long chen
     * @description 重写findClass方法
     * @datetime 2021/2/28 23:34:07
    *//*
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // TODO Auto-generated method stub

        String fileName = getFileName(name);

        File file = new File(libPath,fileName);

        try {
            FileInputStream is = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            try {
                while ((len = is.read()) != -1) {
                    bos.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] data = bos.toByteArray();
            is.close();
            bos.close();

            return defineClass(name,data,0,data.length);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return super.findClass(name);
    }*/

    //获取要加载 的class文件名
    private String getFileName(String name) {
        // TODO Auto-generated method stub
        int index = name.lastIndexOf('.');
        System.out.println("index = " + index);
        if(index == -1){
            return name+".class";
        }else{

            return name.substring(index+1)+".class";
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //创建自定义classloader对象。
        MyClassLoader diskLoader = new MyClassLoader("D:\\repository\\Java-Study\\src\\ClassLoaderTest");
        try {
            //加载class文件
            Class c = diskLoader.loadClass("ClassLoaderTest.Demo");

            if(c != null){
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("say",null);
                    //通过反射调用Test类的say方法
                    method.invoke(obj, null);
                } catch (InstantiationException | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
