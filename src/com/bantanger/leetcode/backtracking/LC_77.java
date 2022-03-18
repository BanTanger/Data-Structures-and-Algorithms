package com.bantanger.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/18 18:04
 */
public class LC_77 {
    class Solution {
        // 创建两个全局变量存放答案
        LinkedList<Integer> path = new LinkedList<>(); // 用链表加快执行速度
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtracking(n, k, 1);
            return result;
        }

        public void backtracking(int n, int k, int startIndex) {
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }

            // 暴力搜索
            // for(int i = startIndex;i<=n;i++){
            //     path.add(i);
            //     backtracking(n,k,i+1);
            //     path.removeLast();
            // }

            // 剪枝部分优化
            // 目前已经选择的元素：path.size();
            // 还需要的元素个数：k - path.size();
            // 从集合n中至多从该起始位置：n - (k-path.size()) + 1,开始遍历
            // 区间为左闭右闭，所以i <= ,因为在集合中必须从1开始，而数组首位置为0，所以需要加一
            for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
                path.add(i);
                backtracking(n, k, i + 1);
                path.removeLast();
            }
        }
    }
}
