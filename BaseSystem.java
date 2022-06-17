package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

/**
 * @author xiaobailing
 */
public class BaseSystem extends JFrame implements ActionListener{
    Container container;
    JTextField base,input,result;
    JPanel panel;
    JButton clear,get;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear){         //通过点击事件获取点击事件对象
            input.setText("");
            result.setText("");
        }
        else if (e.getSource() == get){
            String in = input.getText();
            String ba = base.getText();
            String output = getResult(in,ba);
            result.setText(output);
        }
    }
    public String getResult(String input,String base) {
        try {
            StringBuilder out = new StringBuilder();
            long m = Integer.parseInt(input);             //把字符串转换为数字
            int ba = Integer.parseInt(base);
            while (m > 0) {
                if (m % ba <= 9) {
                    out.append(m % ba);
                } else {
                    int k = (int) ('A' + m % ba - 10);
                    out.append((char) (k));
                }
                m /= ba;
            }
            out.reverse();
            return out.toString();
        }catch (Exception e){
            return "Error";
        }
    }
    public BaseSystem(){
        container  = getContentPane();
        panel = new JPanel();
        base = new JTextField("请输入你想转化的进制");
        input = new JTextField("请输入十进制数");
        result = new JTextField("答案");
        base.addFocusListener(new FocusListener() {

                                  @Override
                                  public void focusGained(FocusEvent e) {
                                      //得到焦点时，当前文本框的提示文字和创建该对象时的提示文字一样，说明用户正要键入内容
                                      if ("请输入你想转化的进制".equals(base.getText())) {
                                          base.setText("");     //将提示文字清空
                                          base.setForeground(Color.black);  //设置用户输入的字体颜色为黑色
                                      }

                                  }

                                @Override
                                    public void focusLost(FocusEvent e) {
                                    //失去焦点时，用户尚未在文本框内输入任何内容，所以依旧显示提示文字
                                    if ("".equals(base.getText())) {
                                        base.setForeground(Color.gray); //将提示文字设置为灰色
                                        base.setText("请输入你想转化的进制");     //显示提示文字
                                    }

                                }
        });
        input.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                //得到焦点时，当前文本框的提示文字和创建该对象时的提示文字一样，说明用户正要键入内容
                if ("请输入十进制数".equals(input.getText())) {
                    input.setText("");     //将提示文字清空
                    input.setForeground(Color.black);  //设置用户输入的字体颜色为黑色
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                //失去焦点时，用户尚未在文本框内输入任何内容，所以依旧显示提示文字
                if ("".equals(input.getText())) {
                    input.setForeground(Color.gray); //将提示文字设置为灰色
                    input.setText("请输入十进制数");     //显示提示文字
                }

            }
        });
        result.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                //得到焦点时，当前文本框的提示文字和创建该对象时的提示文字一样，说明用户正要键入内容
                if ("答案".equals(result.getText())) {
                    result.setText("");     //将提示文字清空
                    result.setForeground(Color.black);  //设置用户输入的字体颜色为黑色
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                //失去焦点时，用户尚未在文本框内输入任何内容，所以依旧显示提示文字
                if ("".equals(result.getText())) {
                    result.setForeground(Color.gray); //将提示文字设置为灰色
                    result.setText("答案");     //显示提示文字
                }

            }
        });
        clear = new JButton("清空");
        get = new JButton("确认");
        clear.addActionListener(this);
        get.addActionListener(this);
        base.setHorizontalAlignment(JTextField.RIGHT);
        input.setHorizontalAlignment(JTextField.RIGHT);
        result.setHorizontalAlignment(JTextField.RIGHT);
        base.setFont(new Font("黑体",Font.BOLD,23));
        input.setFont(new Font("黑体",Font.BOLD,23));
        result.setFont(new Font("黑体",Font.BOLD,23));
        panel.setLayout(new GridLayout(3,1,30,20));
        panel.setBounds(20,30,250,150);
        clear.setBounds(40,250,100,40);
        get.setBounds(160,250,100,40);
        get.setBackground(new Color(192,192,192));
        get.setFont(new Font("黑体",Font.BOLD,20));
        clear.setBackground(new Color(192,192,192));
        clear.setFont(new Font("黑体",Font.BOLD,20));
        panel.add(base);
        panel.add(input);
        panel.add(result);
        container.add(clear);
        container.add(get);
        setTitle("K进制");
        setLayout(null);
        setBounds(100,200,300,400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ImageIcon imageIcon=new ImageIcon(Objects.requireNonNull(Calculator.class.getResource("K.png")));
        setIconImage(imageIcon.getImage());
        add(panel);
    }
}
