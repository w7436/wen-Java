import java.lang.reflect.Constructor;

/**
 * @ClassName TestEnum
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/25 20:02
 * @Version 1.0
 **/
enum EnumColor{
    RED("红色",1),
    BLACK("黑色",2),
    GREEN("绿色",3);


    private String color;
    int key;
    //默认情况下是私有的
    EnumColor(String color, int key) {
        this.color = color;
        this.key = key;
    }
}


public class TestEnum {
    public static void test1(EnumColor color){
        switch (color){
            case RED:
                System.out.println("红色");
                break;
            case BLACK:
                System.out.println("黑色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            default:
                System.out.println("未知颜色");
        }
    }
    public static void test2(){
        EnumColor[] arr = EnumColor.values();
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]+":"+arr[i].ordinal());
        }

        EnumColor red = EnumColor.valueOf("RED");
        System.out.println(red);

        //注意：字符串的参数如果在枚举类中有对应的成员才可以转化成功
//        EnumColor yellow = EnumColor.valueOf("YELLOW");
//        System.out.println(yellow);

        System.out.println(red.compareTo(EnumColor.RED));//0
        System.out.println(red.compareTo(EnumColor.GREEN));//-2

    }
    //枚举不能进行反射
    public static void test3(){
        try {
            Class<?> enumClass = Class.forName("EnumColor");
            //自己实现枚举的构造方法有两个参数，编译器会增加两个参数一个是整型，一个是字符串型
            Constructor<?> enumConstructor  = enumClass.getDeclaredConstructor(String.class,int.class,String.class,int.class);
            enumConstructor.setAccessible(true);
            EnumColor red = (EnumColor) enumConstructor.newInstance("红色",1,"基类参数",2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        test1(EnumColor.RED);
        test2();
        test3();

    }

}
