package com.bantanger.leetcode.sliding_window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/9 15:43
 */
public class LC_219 {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            // 哈希表存储和降重
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                // 注意这里。相同元素可能出现不止两次，
                // 但如果只保留最前面的元素下标可能没法达到 <= k的要求，
                // 所以要在存哈希的时候进行比较，这也是比较坑的地方
                if (map.containsKey(nums[i])) {
                    if (i - map.get(nums[i]) <= k) return true;
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }

    @Test
    public void test() {
        int k = 1;
        int[] nums = {1, 0, 1, 1};
        new Solution().containsNearbyDuplicate(nums, k);
    }
}
