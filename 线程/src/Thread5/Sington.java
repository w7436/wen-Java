package Thread5;

/**
 * @ClassName Sington
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/24 18:46
 * @Version 1.0
 **/
public class Sington {
    public Sington() {

    }
    //饿汉式
//      private static Sington SINGTON = new Sington();
//    public static Sington getInstance(){
//        return SINGTON;
//    }



    //懒汉式
//    private static Sington SINGTON;
//    public static Sington getInstance(){
//        if (SINGTON == null)
//            SINGTON  = new Sington();
//        return SINGTON;
//    }

    //多重校验锁
    private static volatile Sington SINGTON;
    public static Sington getInstance(){
        if (SINGTON == null){ //提高效率，变量使用volatile保证可见性
            synchronized (Sington.class){
                if (SINGTON == null){//为了保证单例：同一个对象
                    //new对象分解指令：
                    //1.分配内存空间
                    //2.初始化对象
                    //3.赋值
                    SINGTON = new Sington();
                }

            }
        }
        return SINGTON;
    }


}



















