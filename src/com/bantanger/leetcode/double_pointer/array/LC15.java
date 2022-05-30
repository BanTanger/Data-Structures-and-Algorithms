package com.bantanger.leetcode.double_pointer.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/30 17:31
 */
public class LC15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            return SumTarget_N(nums, 3, 0, 0);
        }

        private List<List<Integer>> SumTarget_N(int[] nums, int n, int start, int target) {
            List<List<Integer>> res = new LinkedList<>();
            if (nums.length < 2 || nums == null) return res;
            if (n == 2) {
                int l = start, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[l] + nums[r];
                    int bigNum = nums[r], smallNum = nums[l];
                    if (sum < target) { // 当前和小于目标和，左指针跳到之前不相同的元素
                        while (l < r && nums[l] == smallNum) l++;
                    } else if (sum > target) {
                        while (l < r && nums[r] == bigNum) r--;
                    } else {
                        res.add(new ArrayList<Integer>(Arrays.asList(smallNum, bigNum)));
                        while (l < r && nums[l] == smallNum) l++;
                        while (l < r && nums[r] == bigNum) r--;
                    }
                }
            } else {
                // n > 2 时， 递归计算(n - 1) Sum的结果
                int i = start;
                while (i < nums.length) {
                    int num = nums[i];
                    List<List<Integer>> sub = SumTarget_N(nums, n - 1, i + 1, target - num);
                    for (List<Integer> s : sub) {
                        s.add(num);
                        res.add(s);
                    }
                    while (i < nums.length && num == nums[i]) i++; // 跳过重复数字
                }
            }
            return res;
        }
    }

    @Test
    public void test() {
        int[] nums = {-1,0,1,2,-1,-4};
        new Solution().threeSum(nums);
    }
}
