package gc.log;

/**
 * JVM参数如下:
 * -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 */
public class EdenAllocate {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        // 出现Minor GC
        //回收之前在e
        //回收之后在老年代
        allocation4 = new byte[4 * _1MB];
        //allocation4创建好之后，gc日志的信息为Heap...
    }

    public static void main(String[] args) throws Exception {
        testAllocation();
    }
}