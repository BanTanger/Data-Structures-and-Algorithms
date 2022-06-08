package com.bantanger.leetcode.dynamic_programming.ugly;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/8 12:22
 */
public class LC263 {
    class Solution {
        public boolean isUgly(int n) {
            if (n < 1) return false;
            // 丑数，对于能被2，3，5整除的数就不断整除2，3，5，
            // 如果最后能剩下1代表是丑数，剩下0就不是
            while (n % 5 == 0) n /= 5;
            while (n % 3 == 0) n /= 3;
            while (n % 2 == 0) n /= 2;
            return n == 1;
        }
    }
}
