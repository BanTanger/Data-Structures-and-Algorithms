package com.bantanger.leetcode.weekly_competition.c78;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 20:59
 */
public class LC2270 {
    class Solution {
        public int waysToSplitArray(int[] nums) {
            // 前缀和
            int n = nums.length;
            long[] prefix = new long[n];
            prefix[0] = nums[0];
            for(int i = 1; i < n; i++){
                prefix[i] = nums[i] + prefix[i - 1];
            }
            System.out.println(Arrays.toString(prefix));
            int ans = 0;
            for(int i = 0; i < n - 1; i++) {
                if(prefix[i] >= prefix[n - 1] - prefix[i]) {
                    System.out.print(prefix[i] + " " + prefix[n - 1] + " " + (prefix[n - 1] - prefix[i]));
                    System.out.println();
                    ans++;
                }
            }
            return ans;
        }
    }
    @Test
    public void test(){
        int[] nums = {2,3,1,0};
        new Solution().waysToSplitArray(nums);
    }
}
