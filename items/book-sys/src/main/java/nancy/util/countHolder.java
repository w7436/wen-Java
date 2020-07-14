package nancy.util;

/**
 * @ClassName countHolder
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/14 20:18
 * @Version 1.0
 **/
public class countHolder {
    public static final ThreadLocal<Integer> COUNT = new ThreadLocal<>();

    public static void set(Integer count){
        COUNT.set(count);
    }

    public static int get(){
        return COUNT.get();
    }
    public static void remove(){
        COUNT.remove();
    }
}
