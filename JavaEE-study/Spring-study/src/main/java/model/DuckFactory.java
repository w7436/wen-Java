package model;

/**
 * @ClassName DuckFactory
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/7 12:00
 * @Version 1.0
 **/
public class DuckFactory {

        public static Duck create(){
            Duck d = new Duck();
            d.setName("秀才");
            d.setAge(3);
            return d;
        }

        public Duck create2(){
            Duck d = new Duck();
            d.setName("秀才2");
            d.setAge(4);
            return d;
        }
}
