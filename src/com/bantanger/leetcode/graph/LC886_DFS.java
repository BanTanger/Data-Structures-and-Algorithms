package com.bantanger.leetcode.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/26 10:01
 */
public class LC886_DFS {
    class Solution {
        private boolean ok = true;
        private boolean[] visited;
        private boolean[] color;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            // 节点从1开始，所有数组都需要扩容
            visited = new boolean[n + 1];
            color = new boolean[n + 1];
            // 构建一个图
            List<Integer>[] graph = buildGraph(n, dislikes);
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(graph, i);
                }
            }
            return ok;
        }

        private List<Integer>[] buildGraph(int n, int[][] dislikes) {
            // 图的编号 是 1...n 所以要多开辟一格
            List<Integer>[] graph = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : dislikes) {
                int from = edge[0];
                int to = edge[1];
                // 构建无向图，双向建立边
                graph[from].add(to);
                graph[to].add(from);
            }
            return graph;
        }

        private void dfs(List<Integer>[] graph, int v) {
            if (!ok) return;
            visited[v] = true;
            for (int w : graph[v]) {
                if (!visited[w]) {
                    // 把v节点的邻居w分到不同的组（染成不同的颜色）
                    color[w] = !color[v];
                    dfs(graph, w);
                } else {
                    if (color[w] == color[v]) {
                        // 同一个颜色，代表讨厌的人在同一个组。
                        // 不能分成两组
                        ok = false;
                    }
                }
            }
        }
    }
}
