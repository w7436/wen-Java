package classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;

public class Main {
    public static void main(String[] args) throws Exception{
        // 父加载器为空，使用Bootstrap ClassLoader加载
        System.out.println(new MyClassLoader(null).getParent());//null

        // 无参构造方法，会使用AppClassLoader作为父类加载器
        System.out.println(new MyClassLoader());
        System.out.println(new MyClassLoader().getParent());//App
        System.out.println(new MyClassLoader().getParent().getParent());//Ext
        System.out.println(new MyClassLoader().getParent().getParent().getParent());//null
        // 父加载器默认为AppClassLoader，使用loadClass方法加载类，从上往下加载
        //反射和类加载使用全名
        Class<?> cls = new MyClassLoader().loadClass("classLoader.Person");

        // 使用loadClass遵循双亲委派机制从上往下加载，会加载到jdk的String
        Class<?> stringClazz = new MyClassLoader().loadClass("java.lang.String");
        String abc = (String) stringClazz.getConstructor(String.class)
                .newInstance("ABC");
        System.out.println(abc);

        //出现异常：不能自定义java.开头的包
        Class<?> stringClazz2 = new MyClassLoader().findClass("java.lang.String");
    }
}

class MyClassLoader extends ClassLoader{
    protected MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    protected MyClassLoader() {
        super();
    }

    /**
     * 通过指定的文件路路径进行类的文件加载，实际上就是进行二进制文件读取
     * @return 类文件数据
     * @throws Exception
     */
    private byte[] loadClassData(String className) throws Exception {
        URL target = getClass().getClassLoader().getResource(".");
        String path = URLDecoder.decode(target.getPath(), "UTF-8");
        InputStream input = new FileInputStream(
                path + File.separator + className + ".class");
        // 取得所有字节内容，放到内存中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 读取缓冲区
        byte[] data = new byte[20];
        int temp = 0;
        while ((temp = input.read(data))!=-1){
            bos.write(data,0,temp);
        }
        byte[] result = bos.toByteArray();
        input.close();
        bos.close();
        return result;
    }

    /**
     * 重写findClass表示遵循双亲委派模型，因为类的加载还是通过loadClass方法进入的
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classData = this.loadClassData(name.replaceAll("\\.", "/"));
            return super.defineClass(name, classData,0, classData.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}