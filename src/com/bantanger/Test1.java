package com.bantanger;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/25 21:43
 */
public class Test1 {
    private String user;
    private String pwd;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Test1() {
        new userThread().start();
        new pwdThread().start();
        new check().start();
    }

    public Test1(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    class check extends Thread{
        @Override
        public void run() {

        }
    }

    class userThread extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("线程:" + userThread.class + " 正在读取用户:" + getUser());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class  pwdThread extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("线程:" + pwdThread.class + " 正在读取密码:" + getUser());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Test1 test1 = new Test1();
        FileReader filename = new FileReader
                ("E:\\Java 学习项目集合\\Data-Structures-and-Algorithms\\src\\user.txt");
        BufferedReader br = new BufferedReader(filename);
        String strLine = "";
        while((strLine = br.readLine()) != null){
            String[] st = strLine.split(" ");
            for(int i = 0; i < st.length; i++){
                if(i >> 1 == 0){
                    String substring = st[i].substring(5);
                    test1.setUser(substring);
                } else {
                    String substring = st[i].substring(10);
                    test1.setPwd(substring);
                }
            }
        }
    }
}
