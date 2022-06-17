package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaobailing
 */
public class ShowTime extends JLabel implements ActionListener{
    Timer time;
    SimpleDateFormat m;
    ShowTime(){
         time = new Timer(1000,this);
         m = new SimpleDateFormat("hh:mm:ss");
        time.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == time) {
            Date date = new Date();
            this.setFont(new Font("宋体",Font.BOLD,20));
            this.setText("时间:"+m.format(date));
        }
    }
}