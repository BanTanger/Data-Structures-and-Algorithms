package com.bantanger;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/20 10:53
 */
public class FileSearch {
    private static HashMap<Integer, String> certerias = new HashMap<>();//查询条件

    public static void main(String[] args) {
        System.out.println("请输入查询条件！");
        String query = "";
        System.out.println("--1：指定搜索目录  2：指定文件创建/修改日期范围 3：文件大小范围 4：文件扩展名  5：文件名模式 ");
        Scanner sc = new Scanner(System.in);
        int command = sc.nextInt();
        // 依次读取用户的输入条件
        while (true) {
            switch (command) {
                case 1:
                    System.out.println("请输入要检索目录的绝对路径:");
                    query = sc.next();
                    if (query != null && query.length() > 0) {
                        File f = new File(query);
                        // 输入的搜索路径是合法的目录，则加入搜索条件
                        if (f.exists() && f.isDirectory()) certerias.put(1, query);
                        else System.out.println("输入的路径不合法，请重新输入！");
                    }
                    break;
                case 2:
                    System.out.println("请输入要检索文件的创建日期范围（格式为：yyyy-mm-dd：yyyy-mm-dd，可以只输“:”之前/之后的部分）:");
                    query = sc.next();
                    if (query != null && query.length() > 0) {
                        // 将日期字符串分割为两个日期
                        String[] ds = query.split(":");
                        try {
                            for (String s : ds) {
                                LocalDate ld = LocalDate.parse(s);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        certerias.put(2, query);
                    }
                    break;
                case 3:
                    System.out.println("请输入要检索文件的大小范围（格式为：xxx.xxx~xxx.xxx，单位“M”，可以只输“~”之前/之后的部分）:");
                    query = sc.next();
                    if (query != null && query.length() > 0) {
                        // 将文件大小范围分割为两个字符串
                        String[] ds = query.split("~");
                        try {
                            for (String s : ds) {
                                Double ld = Double.parseDouble(s);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        certerias.put(3, query);
                    }
                    break;
                case 4:
                    System.out.println("请输入要检索文件的扩展名（可以有多个，不同扩展名用空格隔开）:");
                    query = sc.next();
                    if (query != null && query.length() > 0) {

                        certerias.put(4, query);
                    }
                    break;
                case 5:
                    System.out.println("请输入含有通配符的文件名模式:");
                    query = sc.next();

            }
        }
    }
}
