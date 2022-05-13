package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_12;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/6 17:27
 */
public class LC_944 {
    class Solution {
        public int minDeletionSize(String[] strs) {
            int rows = strs.length;
            int cols = strs[0].length();
            int res = 0;
            for (int col = 0; col < cols; ++col) {
                for (int row = 1; row < rows; ++row) {
                    if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                        res++;
                        break;
                    }
                }
            }
            return res;
        }
    }
}
