package nancy;

import java.util.Scanner;

/**
 * @ClassName DivideDef
 * @Description
 * 计算两数相除
 * 对数据类型不一致（NumberFormatException）、
 * 缺少命令行参数（ArrayIndexOutOfBoundsException）、
 * 除数为0（ArithmeticException）
 * 及输入负数（DivideDef自定义的异常）进行异常处理。
 * @Author DELL
 * @Data 2020/6/14 18:12
 * @Version 1.0
 **/

//自定义异常类
class EcDef extends Exception{
    static final long serialVersionUID = -3387524229948L;
    public EcDef(){
    }
    public EcDef(String msg){
        super(msg);
    }
}
public class DivideDef {
    public static void ecm(int i,int j) throws EcDef{
        if(i < 0 || j < 0){
            throw new EcDef("您输入的数值存在负数！");
        }
        System.out.println(i / j);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int m = sc.nextInt();
            int n = sc.nextInt();
            ecm(m,n);
        } catch (NumberFormatException e) {
            System.out.println("输入的数据类型不一样");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch (ArithmeticException e){
            System.out.println("分母为0");
        }catch (EcDef e){
            System.out.println(e.getMessage());
        }

    }
}
