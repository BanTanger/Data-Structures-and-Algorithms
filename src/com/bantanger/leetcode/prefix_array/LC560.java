package com.bantanger.leetcode.prefix_array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/9 9:46
 */
public class LC560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] preSum = new int[n + 1];
            // 哈希表在前缀和时期就进行计算，因为题目要求的是能满足和是k的子数组个数（子数组代表连续）
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1); // 当 need = preSum[i] - k == 0， 先提前记录，避免等下答案没法录进去
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
                int need = preSum[i] - k;
                // 如果之前存在值为need的前缀和
                if (map.containsKey(need)) {
                    ans += map.get(need); // 答案增加
                }
                // 将当前前缀和存入哈希表里
                if (!map.containsKey(preSum[i])) {
                    map.put(preSum[i], 1); // 如果不存在就新增
                    System.out.printf("map.get(%d) = %d", i, map.get(preSum[i]));
                } else {
                    map.put(preSum[i], map.get(preSum[i]) + 1);
                    System.out.printf("map.get(%d) = %d", i, map.get(preSum[i]));
                }
            }
            return ans;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,1,2,1};
        new Solution().subarraySum(nums, 3);
    }
}
