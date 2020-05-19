import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName internStringTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/19 10:00
 * @Version 1.0
 **/
public class internStringTest {


    /**
     *第一句：堆中创建了"hello"，也会在常量池创建"hello"，创建了2个字符串对象
     *第二句：h.intern()会去常量池检查是否有了"hello"，结果发现有了，那么此时返回常量池的引用地址给intern
     * 第三局：此时s1指向堆中的对象，s2指向常量池中的对象
     */
    @Test
    public void test1(){//测试不通过
        String s1 = new String ("hello");
        String s2 = s1.intern();
        Assert.assertTrue(s1==s2);
    }

    @Test
    public void test5(){//测试不通过
        String s1 = new String ("hello");
        s1.intern();
        String s2 = "hello";
        Assert.assertTrue(s1==s2);
    }





    /**
     * 第一句：在堆中创建了两个对象，分别是hel,lo,hello，也会在常量池中创建hel
     * 第二句:直接在常量池中创建“hello",此时常量池中含有hel,lo,hello
     * 第三句:检查常量池是否有"hello"，结果发现有了，返回常量池"hello"的地址，很可惜，没有变量去接收，所以这一句没什么用
     * 第四句：s1指向堆中的对象，S2指向常量池中的对象
     */
    @Test
    public void test2(){//测试不通过
        String s1 = new String("hel") + new String("lo");
        String s2 = "hello";
        s1.intern();
        Assert.assertTrue(s1==s2);
    }


    /**
     * 第一句：堆中的对象hel,lo,hello;常量池中的对象hel,lo
     * 第二句：检查到str01不在常量池中，如果在jdk1.6就讲"hello"添加到常量池中，如果是jdk1.7，那么就在常量池中保存指向堆中的地址
     * 第三句:检查到常量池有一个地址保存了这个串，str1就直接指向这个地址，即还是堆中的"hello"
     * 第四句:s1指向堆中的“hello”,s2指向堆中“hello”
     */
    @Test
    public void test4(){
        String s1 = new String("hel") + new String("lo");
        s1.intern();
        String s2 = "hello";
        Assert.assertTrue(s1==s2);
    }

    @Test
    public void test8(){ //测试不通过
        String s1 = new String("hel") + new String("lo");
        String s2 = "hello";
        String s3 = s1.intern();
        Assert.assertTrue(s2==s3);

    }


    /**
     * 第一句：堆中的对象hel,lo,hello;常量池中的对象hel,lo
     * 第二句：创建常量池中的对象“hello”
     * 第三句：检查常量池中是否有“hello”这个对象，结果发现有了，则返回常量池中的对象引用给s3
     * 第四句：s3指向常量池中的对象，s1指向常量池中的对象
     */
    @Test
    public void test3(){//测试通过
        String s2 = new String("hel") + new String("lo");
        String s1 = "hello";
        Assert.assertTrue(s1==s2.intern());
    }

    @Test
    public void test7(){//测试通过
        String str1 = new String("hello").intern() ;
        String str2 = "hello" ;
        Assert.assertTrue(str1 == str2);
    }





}
