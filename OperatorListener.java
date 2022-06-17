package calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author xiaobailing
 */
public class OperatorListener implements ActionListener {
    /**
     *重写操作符监听方法
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //getActionCommand()得到按钮上的字符串
        if ("K".equals(e.getActionCommand())){
            new BaseSystem();
        }
      else if ("ce".equals(e.getActionCommand())) {
            Calculator.jieguo2.setText("");
            ResultOperation.changeResult(false);
        }
        else if ("c".equals(e.getActionCommand())) {
            Calculator.jieguo2.setText("");
            Calculator.jieguo.setText("");
            ResultOperation.changeResult(false);
        }
       else if("<--".equals(e.getActionCommand())) {
            String s = Calculator.jieguo2.getText();

            if (s.length() != 0) {
                String str = Calculator.jieguo2.getText();
                str = str.substring(0, str.length() - 1);
                Calculator.jieguo2.setText(str);
            }
        }
       else if ("+/-".equals(e.getActionCommand())){
            String s = Calculator.jieguo2.getText();
            if(s.length()==0) {
                s = "-";
            }
            else if(s.charAt(0)!='-') {
                s = "-"+s;
            }
            else if (s.charAt(0) == '-'){
                s = s.substring(1);
            }
            Calculator.jieguo2.setText(s);
        }
        else {
            ResultOperation.changeResult(false);
            String str = Calculator.jieguo.getText();
            str += Calculator.jieguo2.getText();
            str += e.getActionCommand();
            Calculator.jieguo.setText(str);
            Calculator.jieguo2.setText("");
        }
    }
}
