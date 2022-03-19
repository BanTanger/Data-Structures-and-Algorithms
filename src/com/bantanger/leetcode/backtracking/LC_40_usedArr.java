package com.bantanger.leetcode.backtracking;

import java.util.*;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/19 7:46
 */
public class LC_40_usedArr {
    class Solution {
        // 创建两个全局变量存放结果
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates); // 剪枝和去重的操作需要对数组进行排序
            backtracking(candidates, target, 0, new boolean[candidates.length]);
            // 创建used布尔类型数组记录在同一树层是否有重复元素被使用了
            return result;
        }

        public void backtracking(int[] candidates, int target, int index, boolean[] used) {
            if (target == 0) { // 当目标值被缩减成零，一条组合已经成功，将其加入result结果中
                result.add(new ArrayList(path));
                return;
            }

            // 初始化 i = index 将 index 和 i 进行绑定
            // 第二逻辑条件 candidates[i] <= target 是剪枝操作: 检测当前目标数是否还能被剩余数据减去
            for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
                if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                    // i > 0 用来过滤 i == 0 ,避免越界报错
                    // 条件：candidates[i] == candidates[i - 1] && !used[i - 1]
                    // 用来判断是否有重复数据 -> 此时for循环是在遍历树层的重复元素还是树枝的重复元素
                    continue;
                }
                used[i] = true; // 当前数据被使用
                path.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i + 1, used);
                used[i] = false; // 回溯操作，将数据清除
                path.removeLast(); // 回溯
            }
        }
    }
}
