package com.bantanger.leetcode.dynamic_programming.buy_and_sel_stocks;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/15 8:08
 */
public class LC_121_one_time_greedy {
    class Solution {
        public int maxProfit(int[] prices) {
            int low = Integer.MAX_VALUE;
            int result = 0;
            // 贪心没有初始化的过程，所以i要从0开始遍历
            for (int i = 0; i < prices.length; i++) {
                low = Math.min(low, prices[i]);
                result = Math.max(result, prices[i] - low);
            }
            return result;
        }
    }
}
