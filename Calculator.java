package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;
 
/**
 * @author xiaobailing
 */
public class Calculator extends JFrame{
    /**
     * 定义属性
     */
    ShowTime showTime;
    JLabel jLabel;
    Container container;
    JPanel panel;
    JPanel panel2;
    JButton[] jButton;
    /**
     * 定义计算所需要的符号
     */
    static String[] fuhao = {"c","ce","<--","/","7","8","9","*","4","5","6","-","1","2","3","+","+/-","0",".","=","(",")","K"};
    /**
     * 定义两个文本框
     */
    static JTextField jieguo = new JTextField();//俩个文本框
    static JTextField jieguo2 = new JTextField();
    /**
     *定义监听器数组
     */
    ActionListener[] listener = new ActionListener[100];
    /**
     *进行界面初始化
     */
    public Calculator(String s, int x, int y, int w, int h){
        init(s);
        add(showTime);
        container.setLayout(null);
        panel.add(jieguo);
        panel.add(jieguo2);
        panel.setBounds(x,y,w*3/4,h/4);
        panel2.setBounds(x,y+h/4,w*3/4,450);
        showTime.setBounds(290,590,300,100);
        container.add(panel);
        container.add(panel2);
        setBounds(x, y, w, 700);
        setVisible(true);
        setResizable(false);
        //不能改变大小
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //结束一切
        ImageIcon imageIcon=new ImageIcon(Objects.requireNonNull(Calculator.class.getResource("计算器.jpg")));
        setIconImage(imageIcon.getImage());
        //插图
    }
    void init(String s){
        setTitle(s);
        showTime = new ShowTime();
        jLabel = new JLabel();
        //标签
        container = getContentPane();
        panel = new JPanel(new GridLayout(3,1));
        //格子布局
        panel2=new JPanel(new GridLayout(6,4));
        jButton = new JButton[23];
        jieguo.setFont(new Font("黑体",Font.BOLD,20));
        //输入显示的框框
        jieguo2.setFont(new Font("黑体",Font.BOLD,23));
        jieguo.setHorizontalAlignment(JTextField.RIGHT);
        //又对齐文字
        jieguo2.setHorizontalAlignment(JTextField.RIGHT);
        for(int i=0;i<jButton.length;i++){
            jButton[i] = new JButton(fuhao[i]);
            jButton[i].setBackground(new Color(192,192,192));
            //颜色
            jButton[i].setFont(new Font("黑体",Font.BOLD,20));
            //字体
            String regex="[K<ce*+-/]+";
            if(fuhao[i].matches(regex)){
                listener[i] = new OperatorListener();
                //除去等号数字外的处理事件
            }
            else if ("=".equals(fuhao[i])) {
                //结果运算 单列
                listener[i] = new ResultOperation();
            }
            else {
                listener[i] = new NumListener();
                //数字在第二行行的累加
            }
            jButton[i].addActionListener(listener[i]);
            panel2.add(jButton[i]);
        }
    }
}