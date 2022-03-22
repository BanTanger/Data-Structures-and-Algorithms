package com.bantanger.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/22 9:58
 */
public class LC_46_Permutations {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean used[]; // 使用used数组记录

        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) {
                return result;
            }
            used = new boolean[nums.length];
            backtracking(nums);
            return result;
        }

        // 实际上每层递归都是将这个集合的元素再遍历一遍，通过使用used，
        // 记录当前层数之前的所有层数选择过的元素，当前层不能再使用这些元素
        public void backtracking(int[] nums) {
            if (nums.length == path.size()) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue; // 如果当前层遍历到之前选择过的元素就直接跳过，检查下一个元素
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums);
                path.removeLast();
                used[i] = false; // 回溯，下一个大树枝还可以使用所有元素
            }
        }
    }
    @Test
    public void test(){
        int[] nums = {1,2,3};
        new Solution().permute(nums);
    }
}
