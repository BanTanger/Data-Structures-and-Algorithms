package com.bantanger.leetcode.dynamic_programming.subarray;

import java.util.HashSet;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/18 10:17
 */
public class LC128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            int maxLen = 0;
            for (Integer num : set) {
            /*
            若当前遍历的数减一已经存在set中，
            则此数开头的序列必不可能最长，
            直接跳过进行下一次遍历
             */
                if (!set.contains(num - 1)) {
                    int cur = num;
                    int curLen = 1; // 记录当前子串长度
                    while (set.contains(cur + 1)) { // 左边没有就往右边搜索
                        cur++;
                        curLen++;
                    }
                    maxLen = Math.max(maxLen, curLen);
                }
            }
            return maxLen;
        }
    }
}
