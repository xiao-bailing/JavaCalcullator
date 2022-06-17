package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author xiaobailing
 */
public class ResultOperation implements ActionListener {
    static boolean Result = false;
    /**
     *改变Result状态
     */
    public static void changeResult(boolean state){
        Result = state;
    }
    /**
     *重写等号监听器方法
     */
    @Override
    public  void  actionPerformed(ActionEvent e){
        if(Result) {
            return;
        }
        ResultOperation.changeResult(true);
        String str  = Calculator.jieguo.getText();
        str += Calculator.jieguo2.getText();
        int index = str.lastIndexOf("=");
       String str1 = str.substring(index+1);        //截取从左往右的第index+1的字符
        String ans  = GetResult.main(str1);
        str += e.getActionCommand();
        Calculator.jieguo.setText(str);
        Calculator.jieguo2.setText(""+ans);
    }
}
