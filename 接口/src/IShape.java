/*接口关键字是interface
2.接口中的方法 全部不能有具体的实现，都是抽象的方法——默认的public abstract
3.接口当中的成员变量是public static final
4.接口是不可以被实例化的 new
5.类和接口是实现，接口和接口是继承
*/
interface A{
    void funcA();
}
interface T{
    void funcT();
}
//此时B就包含A，T的功能
interface B extends A,T{
    void funcB();
}
class C implements B{
    @Override
    public void funcB() { }

    @Override
    public void funcA() { }

    @Override
    public void funcT() { }
}
public interface IShape {
    int size=0;
    void draw();
}
