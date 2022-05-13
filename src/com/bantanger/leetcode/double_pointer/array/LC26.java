package com.bantanger.leetcode.double_pointer.array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 10:08
 */
public class LC26 {
    int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }

}
