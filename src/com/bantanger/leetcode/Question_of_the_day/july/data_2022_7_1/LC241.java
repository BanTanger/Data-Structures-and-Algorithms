package com.bantanger.leetcode.Question_of_the_day.july.data_2022_7_1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/1 22:03
 */
public class LC241 {
    class Solution {
        char[] cs;
        public List<Integer> diffWaysToCompute(String expression) {
            cs = expression.toCharArray();
            return dfs(0, cs.length - 1);
        }
        private List<Integer> dfs(int l, int r) {
            List<Integer> ans = new ArrayList<>();
            for (int i = l; i <= r; i++) {
                // 只选取为符号的cs数据
                if (cs[i] >= '0' && cs[i] <= '9') continue; // 当前i必须为符号位才能走
                // 划分左右两边的式子，由后序遍历的思想获取到当前左右式子的所有可能情况
                List<Integer> part1 = dfs(l, i - 1), part2 = dfs(i + 1, r);
                for (int a : part1) {
                    for (int b : part2) {
                        int cur = 0;
                        if (cs[i] == '+') cur = a + b;
                        else if (cs[i] == '-') cur = a - b;
                        else cur = a * b;
                        ans.add(cur);
                    }
                }
            }
            if (ans.isEmpty()) {
                // 划分的两个区间并没有任何可能结果，代表当前这个string是一个完整的数据，直接输出即可
                int cur = 0;
                for (int i = l; i <= r; i++) {
                    cur = cur * 10 + (cs[i] - '0');
                }
                ans.add(cur);
            }
            return ans;
        }
    }
}
