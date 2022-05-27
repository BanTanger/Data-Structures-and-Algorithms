package com.bantanger.leetcode.weekly_competition.c291;

import java.util.HashSet;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/27 15:54
 */
public class LC2261 {
    class Solution {
        public int countDistinct(int[] nums, int k, int p) {
            HashSet<String> ans = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int cnt = 0;
                StringBuffer sb = new StringBuffer();
                for (int j = i; j < nums.length; j++) {
                    sb.append(nums[j]).append("#"); // 添加一个#辨别单位数和多位数
                    // 1#9 和 19
                    if (nums[j] % p == 0) cnt++;
                    if (cnt > k) break;
                    ans.add(sb.toString());
                }
            }
            return ans.size();
        }
    }
}
