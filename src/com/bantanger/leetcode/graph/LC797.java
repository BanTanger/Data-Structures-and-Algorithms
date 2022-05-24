package com.bantanger.leetcode.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 13:12
 */
public class LC797 {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            LinkedList<Integer> path = new LinkedList<>();
            traverse(graph, 0, path);
            return res;
        }

        private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
            // 添加节点到路径中
            path.add(s);

            int n = graph.length;
            if (s == n - 1) {
                // 到达终点
                res.add(new LinkedList<>(path));
            }

            for (int point : graph[s]) {
                traverse(graph, point, path);
            }

            // 从路径中移除当前的s
            path.removeLast();
        }
    }
}
