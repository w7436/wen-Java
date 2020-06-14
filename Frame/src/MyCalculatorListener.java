import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName MyCalculatorListener
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/13 14:36
 * @Version 1.0
 **/
//监听器类
public class MyCalculatorListener implements ActionListener {
    private TextField num1,num2,num3;

    public MyCalculatorListener(TextField num1,TextField num2,TextField num3){
        this.num1=num1;
        this.num2=num2;
        this.num3=num3;
    }

    public void actionPerformed(ActionEvent e){
        //1.获得加数和被家数
        int n1=Integer.parseInt(num1.getText());
        int n2=Integer.parseInt(num2.getText());
        //2.将值加法运算后放到第三个框
        num3.setText(""+(n1+n2));

    }


}

