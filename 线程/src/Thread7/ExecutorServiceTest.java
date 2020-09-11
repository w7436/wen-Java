package Thread7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ExecutorServiceTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/19 10:54
 * @Version 1.0
 **/
public class ExecutorServiceTest {

    //设置线城池的数量，可以根据单个任务量+主机配置+坏境（系统运行其他程序）
    //单个主机运行的主任务是本程序，推荐任务数量根据处理器的核数来决定
    private static int COUNT = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        //数量为1 的固定大小的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //固定大小的线程池：给定数量的正式员工，没有临时工
        ExecutorService pool1 = Executors.newFixedThreadPool(4);
        //没有正式工，都为临时工（外包公司）
        ExecutorService pool2 = Executors.newCachedThreadPool();
        //定时任务的线城池（有正式，也有临时工）
        ExecutorService pool3 = Executors.newScheduledThreadPool(4);
    }
}























