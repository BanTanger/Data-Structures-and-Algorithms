package com.bantanger.leetcode.bit_manipulation;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/23 22:18
 */
public class BitTest {
    @Test
    public void OrTest(){
        char i = 'a' | ' ';
        char i1 = 'A' | ' ';
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i == i1);
    }

    @Test
    public void AndTest(){
        char i = 'b' & '_';
        char i1 = 'B' & '_';
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i1 == i);
    }

    @Test
    public void XORTest() {
        char i = 'D' ^ ' ';
        char i1 = 'd' ^ ' ';
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i1 == i);
    }

    @Test
    public void Test(){
        int x = -1, y = 2;
        boolean f = ((x ^ y) < 0); // true;
        System.out.println(f);

        int x1 = 3, y1 = 2;
        boolean f1 = ((x1 ^ y1) < 0); // false;
        System.out.println(f1);
    }
}
