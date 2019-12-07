/**
 * @ClassName Shape2
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/4 17:52
 * @Version 1.0
 **/
/**1.抽象类不能被实例化 new
 * 2.抽象类当中可以有抽象方法 也可以有非抽象方法或者成员变量
 * 抽象类的产生就是为了继承
*
*/
abstract public class Shape2 {
    public int a=10;

    public abstract void draw();

    public void func(){
        System.out.println("func()");
    }
}
