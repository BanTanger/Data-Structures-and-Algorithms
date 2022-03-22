package com.bantanger.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/22 10:49
 */
public class LC_46_PermutationsⅡ {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums.length == 0) return result;
            used = new boolean[nums.length];
            Arrays.sort(nums);
            backtracking(nums);
            return result;
        }

        public void backtracking(int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
                // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
                // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;
                /*
                    i > 0 防止数组越界 used[i - 1]
                    nums[i] == nums[i - 1] 前后重复0
                    used[i - 1] == false 检查重复元素是否使用
                 */
                if (!used[i]) {
                    used[i] = true;
                    path.add(nums[i]);
                    backtracking(nums);
                    path.removeLast();
                    used[i] = false;
                }
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {1,1,1};
        new Solution().permuteUnique(nums);
    }
}
