package com.bantanger.leetcode.weekly_competition.c302;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/17 12:59
 */
public class LC6120 {
    class Solution {
        public int[] numberOfPairs(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            boolean[] visit = new boolean[110];
            int pairs = 0, count = 0;
            for (int num : nums) {
                if (visit[num]) continue;
                if (map.get(num) % 2 != 0) count++;
                pairs += map.get(num) / 2;
                visit[num] = true;
            }
            return new int[]{pairs, count};
        }
    }
    @Test
    public void test() {
        int[] nums = {5,12,53,22,7,59,41,54,71,24,91,74,62,47,20,14,73,11,82,2,15,38,38,20,57,70,86,93,38,75,94,19,36,40,28,6,35,86,38,94,4,90,18,87,24,22};
        new Solution().numberOfPairs(nums);
    }
}
