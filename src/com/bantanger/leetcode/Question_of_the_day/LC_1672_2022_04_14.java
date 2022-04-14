package com.bantanger.leetcode.Question_of_the_day;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/14 7:28
 */
public class LC_1672_2022_04_14 {
    class Solution {
        public int maximumWealth(int[][] accounts) {
            if (accounts.length == 1 && accounts[0].length == 1)
                return accounts[0][0];
            int sum = 0, max = 0;
            for (int[] account : accounts) {
                for (int num : account) {
                    sum += num;
                }
                max = Math.max(max, sum);
                sum = 0;
            }
            return max;
        }
    }

    @Test
    public void test() {
        int[][] accounts = {{6, 59, 64, 19, 30, 76, 71, 86, 90, 25, 56, 17, 19, 72, 61, 56, 24, 40, 35, 39, 67, 28, 52, 11, 82, 72, 8, 82, 81, 47}};
        int i = new Solution().maximumWealth(accounts);
        System.out.println(i);
    }
}
