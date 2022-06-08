package com.bantanger.leetcode.prefix_array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/8 22:50
 */
public class LC_862 {
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            // 本题和LC523有异曲同工之妙，但肯定不止那么简单
            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            int[] preSum = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
                // System.out.println(preSum[i]);
            }
            // 使用哈希表降低一层for
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i <= n; i++) {
                int val = preSum[i] % k;
                System.out.println("val = " + val);
                if(!map.containsKey(val)) {
                    map.put(val, i); // 如果不存在，就放置下标。
                }
            }
            for(int i = 1; i <= n; i++) {
                int need = preSum[i] % k;
                if(map.containsKey(need) && i - map.get(need) >= 1) {
                    System.out.printf("get(%d) = %d", need, map.get(need));
                    ans = Math.min(ans, i - map.get(need));
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

    class Solution2 {
        public int shortestSubarray(int[] nums, int k) {
            // 本题和LC523有异曲同工之妙，但肯定不止那么简单
            if(nums.length == 1 && nums[0] == k) return 1;
            if(nums.length == 1 && nums[0] != k) return -1;
            int n = nums.length;
            // int ans = Integer.MAX_VALUE;
            int[] preSum = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            int l = 0, r = 0;
            //数组模拟队列
            int[] q = new int[n+1];
            int res = Integer.MAX_VALUE;
            for(int i = 1; i <= n; i++) {
                //使得sum[j] 尽可能的小，因此
                while(l <= r && preSum[q[r]] >= preSum[i]) r--;
                while(l <= r && preSum[i] - preSum[q[l]] >= k) {
                    res = Math.min(res, i - q[l]);
                    l++;
                }
                q[++r] = i;
            }
            return res != Integer.MAX_VALUE ? res : -1;
        }
    }

    @Test
    public void test () {
        int[] nums = {48,99,37,4,-31};
        new Solution().shortestSubarray(nums, 140);
    }
}
