package com.bantanger.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/22 9:03
 */
public class LC_491_IncreasingSubsequences {
    class Solution {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            backtracking(nums, 0);
            return result;
        }

        // 不能有重复元素，所以还需要startIndex来调整下一层递归的起始位置
        public void backtracking(int[] nums, int startIndex) {
            if (path.size() > 1) { // 题目要求至少存在两个元素的递归序列，所以集合只放了单个元素时不进入条件
                result.add(new ArrayList(path));
                // 注意不要写return，因为要搜索整个树
            }
            // 设置哈希数组
            int[] used = new int[201]; // 100 + | -100 | + 0
            for (int i = startIndex; i < nums.length; i++) {
                if (!path.isEmpty() &&
                        nums[i] < path.get(path.size() - 1) ||
                        (used[nums[i] + 100] == 1)) continue;
                /*
                    !path.isEmpty() 因为后面需要取用path的元素，要考虑当前path是否为空，不然会编译错误
                    nums[i] < path.get(path.size() - 1)，判断当前是否满足递增子序列，注意给出的元素集合是乱序的
                    (used[nums[i] + 100] == 1) 哈希数组中查到当前遍历的元素是重复出现的，直接continue
                 */
                used[nums[i] + 100] = 1; // 标记当前元素，哈希数组
                path.add(nums[i]);
                backtracking(nums, i + 1);
                path.removeLast();
            }
        }
    }
}
