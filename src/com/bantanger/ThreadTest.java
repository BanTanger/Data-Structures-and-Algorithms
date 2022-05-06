package com.bantanger;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/25 21:43
 */
public class ThreadTest extends JFrame {
    private JLabel lblTime = new JLabel();
    private JLabel lblDo = new JLabel();

    public ThreadTest() {
        this.setLayout(new GridLayout(2, 1));
        add(lblTime);
        add(lblDo);
        new TimeThread().start();
        new DoThread().start();
    }

    private class TimeThread extends Thread {
        public void run() {
            while (true) {
                Calendar calendar = new GregorianCalendar();
                lblTime.setFont(new Font("宋体", Font.PLAIN, 23));
                lblTime.setForeground(Color.blue);
                lblTime.setText(String.format("现在是：%d年%02d月%02d日 %02d:%02d:%02d",
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH) + 1,
                        calendar.get(Calendar.DATE),
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        calendar.get(Calendar.SECOND)));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class DoThread extends Thread {
        public void run() {
            while (true) {
                Calendar calendar = new GregorianCalendar();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                lblDo.setForeground(Color.blue);
                lblDo.setFont(new Font("宋体", Font.PLAIN, 23));
                if (8 <= hour && hour < 9) {
                    lblDo.setText("消息：该上课了");
                } else if (23 <= hour || hour < 8) {
                    lblDo.setText("消息：该休息了");
                } else {
                    lblDo.setText("消息：无");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ThreadTest();
                frame.setSize(500, 300);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
