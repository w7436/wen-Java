package gc.log;

/**
 * JVM参数如下:
 * -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * @author 38134
 *
 */
 public class OldToTenured {
    private static final int _1MB = 1024 * 1024;

    @SuppressWarnings("unused")
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
// 什么时候进入老年代取决于XX:MaxTenuringThreshold的设置
        allocation1 = new byte[4 * _1MB];
        //eden区是8M，不能存放新对象：Minor GC
        //回收前：e区存放的allocation1，allocation1
        //回收后，：老年代存放allocation1，allocation2
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        //  allocation3引用的对象没有GC Roots引用就可以回收
        //新创建的对象也是4m+垃圾对象4m---->e区不能存放 ：出发Minor GC
        allocation3 = new byte[4 * _1MB];
    }

    public static void main(String[] args) throws Exception {
        testAllocation();
    }
}