package com.bantanger.leetcode.backtracking;

import java.util.*;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/19 8:23
 */
public class LC_40_StartIndex {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        int sum = 0; // 使用全局变量sum比较target。( 模拟递归 )

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtracking(candidates, target, 0);
            return result;
        }

        public void backtracking(int[] arr, int target, int startIndex) {
            if (sum == target) {
                result.add(new ArrayList(path));
                return;
            }
            for (int i = startIndex; i < arr.length && sum + arr[i] <= target; i++) {
                // 通过判断重复元素时是否 i > startIndex,
                // 因为在搜索同一树枝时其实startIndex会更新。
                // 所以能通过比较区分重复元素是位于同一树层还是树枝
                if (i > startIndex && arr[i] == arr[i - 1]) {
                    continue;
                }
                sum += arr[i];
                path.add(arr[i]);
                backtracking(arr, target, i + 1);
                // int temp = path.getLast();
                // sum -= temp;
                // path.removeLast();
                sum -= path.removeLast(); // 一样的效果
            }
        }
    }
}
