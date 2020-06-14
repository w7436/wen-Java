import javax.swing.*;
import java.awt.*;

/**
 * @ClassName Calculate
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/13 14:26
 * @Version 1.0
 **/
public class Calculate extends Frame{
    public Calculate(){
        //3个文本框
        TextField num1=new TextField(10);
        TextField num2=new TextField(10);
        TextField num3=new TextField(20);
        JFrame frame=new JFrame();
        //1个按钮
        Button but=new Button("=");
        but.addActionListener(new MyCalculatorListener(num1,num2,num3));
        //1个标签
        Label lab=new Label("+");
        //布局
        setLayout(new FlowLayout());
        add(num1);
        add(lab);
        add(num2);
        add(but);
        add(num3);
        pack();
//		设置点击关闭后,关闭程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}




