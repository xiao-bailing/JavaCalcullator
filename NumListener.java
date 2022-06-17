package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *重写数字输入监听器方法
 * @author xiaobailing
 */
public class NumListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){
        String str = Calculator.jieguo2.getText();
        str += e.getActionCommand();
        //得到按钮上的字符串
        Calculator.jieguo2.setText(str);
    }

}
