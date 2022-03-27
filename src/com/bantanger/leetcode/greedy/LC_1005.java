package com.bantanger.leetcode.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/27 8:28
 */
public class LC_1005 {
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            nums = IntStream.of(nums).boxed()
                    .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                    .mapToInt(Integer::intValue).toArray();
            int len = nums.length;
            for (int i = 0; i < len; i++) { // 将绝对值大的负数转正
                if (nums[i] < 0 && k > 0) {
                    nums[i] = -nums[i];
                    k--;
                }
            }
            // 如果k在遍历之后依然 > 0时，就取当前绝对值最小的数
            if (k % 2 == 1) nums[len - 1] = -nums[len - 1];
            return Arrays.stream(nums).sum(); //
        }
    }
}
