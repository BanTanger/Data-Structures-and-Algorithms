package com.bantanger.leetcode.weekly_competition.c297;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/12 20:08
 */
public class LC5289 {
    class Solution {
        int ans = Integer.MAX_VALUE;
        int k;
        int[] sum;

        private void dfs(int nums, int[] q) {
            if (nums == q.length) {
                // 寻找每组饼干的最大值
                int max = 0;
                for (int i = 0; i < k; i++) {
                    max = Math.max(max, sum[i]);
                }
                ans = max;
                return;
            }
            for (int i = 0; i < k; i++) {
                sum[i] += q[nums];
                if (sum[i] < ans) { // 如果当前答案还没有超过范围，就递归爆搜
                    dfs(nums + 1, q);
                }
                sum[i] -= q[nums];
            }
        }

        public int distributeCookies(int[] cookies, int k) {
            // 数据量只有八，可以直接使用爆搜
            this.k = k;
            sum = new int[k];
            dfs(0, cookies);
            return ans;
        }
    }

    @Test
    public void test(){
        int[] cookies = {8,15,10,20,8};
        new Solution().distributeCookies(cookies, 2);
    }
}
