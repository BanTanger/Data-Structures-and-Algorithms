package com.bantanger.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/21 10:23
 */
public class LC_78 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtracking(nums, 0);
            return result;
        }

        // 先序遍历把所有节点记录到结果数组中
        public void backtracking(int[] nums, int startIndex) {
            result.add(new ArrayList(path)); // 中
            if (startIndex >= nums.length) return;
            for (int i = startIndex; i < nums.length; i++) {
                path.add(nums[i]);
                backtracking(nums, i + 1);
                path.removeLast();
            }
        }
    }

    @Test
    public void Test(){
        int[] arr = {1,2,3};
        new Solution().subsets(arr);
    }
}
