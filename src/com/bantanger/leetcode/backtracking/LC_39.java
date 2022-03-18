package com.bantanger.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/18 17:30
 */
public class LC_39 {
    class Solution {
        // 创建全局变量 二维数组和一维数组
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates); // 先对数组进行排序操作，排序后剪枝减少无效操作
            backtracking(candidates, target, 0);
            return result;
        }

        /**
         * 递归过程中缩小目标和并带有回溯过程
         *
         * @param candidates 传入数组
         * @param target     目标和
         * @param startIndex 当前执行到的位置
         */
        public void backtracking(int[] candidates, int target, int startIndex) {
            if (target < 0 || candidates[startIndex] > target) {
                return; // 剪枝操作
                // 目标和已经被缩小到小于零或者当前指针指向的数组数字大于目标和就跳出递归不执行
            }
            if (target == 0) {
                result.add(new ArrayList(path));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                path.add(candidates[i]); // 添加当前指针指向数组的数字
                backtracking(candidates, target - candidates[i], i); // 自带回溯过程
                path.removeLast(); // 回溯
            }
        }
    }
}
