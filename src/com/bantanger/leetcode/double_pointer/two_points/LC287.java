package com.bantanger.leetcode.double_pointer.two_points;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/31 19:43
 */
public class LC287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            slow = nums[slow];
            fast = nums[nums[fast]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
                System.out.println("slow : " + slow);
                System.out.println("fast : " + fast);
            }
            // 此时快慢指针指向同一个位置
            int pre1 = 0; // 重置快指针
            int pre2 = slow;
            while (pre1 != pre2) { // 寻找环入口
                pre1 = nums[pre1];
                pre2 = nums[pre2];
            }
            return pre1;
        }
    }
    @Test
    public void test() {
        int[] nums = {1,3,4,2,2};
        new Solution().findDuplicate(nums);
    }
}
