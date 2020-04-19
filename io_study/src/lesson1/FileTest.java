package lesson1;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/11 9:14
 * @Version 1.0
 **/
public class FileTest {

    @Test
    public void testRead1() throws IOException {
        //字节流转换为字符流，需要使用字节字符转换流
        // （InputStreamReader输入的字节字符转换流，
        // 或者OutputStreamWriter:输出的字节字符转换流）

        //转换流可以设置编码：java文件的编码格式，文件的编码格式

        FileInputStream fis = new FileInputStream(
                new File("D:\\bit\\github\\wen-Java\\io_study\\res\\info.txt"));
        BufferedReader br = new BufferedReader(
                new InputStreamReader(fis,"UTF-8"));
//        String line;
//        while ((line = br.readLine())!=null){
//            System.out.println(line);
//
//        }
        char[] chars = new char[1024];
        int len;
        while((len = br.read(chars,0,1024))!=-1){
            String str = new String(chars);
            System.out.println(str);
        }
    }

    @Test
    public void testRead2() throws IOException {
        //字节流转换为字符流，需要使用字节字符转换流
        // （InputStreamReader输入的字节字符转换流，
        // 或者OutputStreamWriter:输出的字节字符转换流）

        //转换流可以设置编码：java文件的编码格式，文件的编码格式

        FileInputStream fis = new FileInputStream(
                new File("D:\\bit\\github\\wen-Java\\io_study\\res\\info.txt"));
        //按字节读取
        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read(bytes,0,1024))!= -1){
            String str = new String (bytes,0,len);
            System.out.println(str);
        }
    }

    @Test
    public void testWrite1() throws IOException {

        FileOutputStream fos = new FileOutputStream(
                new File("D:\\bit\\github\\wen-Java\\io_study\\res\\info.txt"));
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
        //使用缓冲流，输出的时候，要进行flush刷新缓存区，否则不会真实输出数据到目的设备
        br.write("你好");//write写数据到系统内存缓冲区
        br.write("世界");
        br.flush();//缓存区刷新，发送数据到目的设备
    }

    @Test
    public void copyFile() throws IOException {
        FileInputStream fis = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        BufferedWriter br1 = null;
        try {
            //复制本地文件
           fis = new FileInputStream(
                    new File("D:\\bit\\github\\wen-Java\\io_study\\res\\info.txt"));
           br = new BufferedReader(
                    new InputStreamReader(fis));

           fos = new FileOutputStream(
                    new File("D:\\bit\\github\\wen-Java\\io_study\\res\\info1.txt"));
           br1 =  new BufferedWriter(new OutputStreamWriter(fos));

            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes,0,1024))!= -1){
                br1.write(new String(bytes,0,len));
                br1.flush();
            }
        }finally {//IO流的操作完成后释放资源，顺序是根据依赖关系
            if(br!=null){
                br.close();
            }
            if(fis!=null){
                fis.close();
            }
            if(br1!=null){
                br1.close();
            }
            if(fos!=null){
                fos.close();
            }
        }

    }
}

















