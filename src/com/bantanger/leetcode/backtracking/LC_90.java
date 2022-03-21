package com.bantanger.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/21 11:02
 */
public class LC_90 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtracking(nums, 0);
            return result;
        }

        public void backtracking(int[] nums, int startIndex) {
            result.add(new ArrayList(path));
            if (startIndex >= nums.length) return;
            for (int i = startIndex; i < nums.length; i++) {
                if (i > startIndex && nums[i] == nums[i - 1]) { // 去重模板
                    continue;
                }
                path.add(nums[i]);
                backtracking(nums, i + 1);
                path.removeLast();
            }
        }
    }
}
