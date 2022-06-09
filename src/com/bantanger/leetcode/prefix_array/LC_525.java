package com.bantanger.leetcode.prefix_array;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/9 10:17
 */
public class LC_525 {
    class Solution {
        public int findMaxLength(int[] nums) {
            // 把0看成-1，那么结果就变成求 和为0的最长连续子数组
            // 那么使用前缀和 + 哈希表的思路。并且要求i - j 经可能的大
            int n = nums.length;
            int[] preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1); // 对题目稍微变形，这样求得就是和 为 0的数据
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < preSum.length; i++) {
                int val = preSum[i];
                if (!map.containsKey(val)) {
                    map.put(val, i);
                }
            }
            int ans = 0;
            for (int i = 1; i < preSum.length; i++) {
                int need = preSum[i];
                if (map.containsKey(need)) {
                    ans = Math.max(ans, i - map.get(need));
                }
            }
            return ans;
        }
    }

}
