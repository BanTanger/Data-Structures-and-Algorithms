package com.bantanger.leetcode.greedy;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/26 17:22
 */
public class LC_122 {
    class Solution {
        public int maxProfit(int[] prices) {
            // 贪心,很难想
            // 只看每天正利润股票
            int result = 0;
            for(int i = 1; i < prices.length ;i++){
                result += Math.max(prices[i] - prices[i - 1],0);
            }
            return result;
        }
    }
}
