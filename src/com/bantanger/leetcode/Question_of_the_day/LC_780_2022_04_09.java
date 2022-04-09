package com.bantanger.leetcode.Question_of_the_day;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/9 12:11
 */
public class LC_780_2022_04_09 {
    class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            while (sx < tx && sy < ty) {
                if (tx < ty) ty %= tx;
                else tx %= ty;
            }
            if (tx < sx || ty < sy) return false;
            return sx == tx ? (ty - sy) % tx == 0 : (tx - sx) % ty == 0;
            // 如果相等，查看sy + sx 是否等于 ty
            // 如果不相等，查看sy + sx 是否等于 tx
        }
    }
}
