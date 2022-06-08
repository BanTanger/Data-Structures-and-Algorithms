package com.bantanger.leetcode.prefix_array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/8 20:39
 */
public class LC_523 {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            // 前缀和
            // 实际上题目拆解成两个需求， i - j > 2 && (preSum[i] - preSum[j]) % k == 0
            // 而(preSum[i] - preSum[j]) % k == 0 与 preSum[i] % k == preSum[j] % k是等价的
            int n = nums.length;
            int[] preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            // 做一个hash来存放所需的前缀和,降低for层数
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < preSum.length; i++) {
                // 在哈希表中记录余数
                int val = preSum[i] % k;
                // 如果当前哈希表没有这个余数的键值，就存一个
                if (!map.containsKey(val)) {
                    map.put(val, i);
                }
                // 如果这个前缀和已经有对应的索引了，则什么都不做
                // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
            }
            // 怎么让子数组最小有两个呢，我们遍历一遍前缀和，对每一个元素取模然后查表，如果发现查表下标 与当前下标相差2，就代表找到
            for (int i = 1; i <= n; i++) {
                int need = preSum[i] % k;
                if (map.containsKey(need) &&
                        i - map.get(need) >= 2) {
                    // 子数组的长度至少要为2
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    public void test() {
        int[] nums = {23, 2, 6, 4, 7};
        System.out.println(new Solution().checkSubarraySum(nums, 13));
    }
}
