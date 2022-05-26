package com.bantanger.leetcode.graph;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/26 9:22
 */
public class LC785_DFS {
    class Solution {
        boolean ok = true; // 判断是否为二分图
        boolean[] color; // color数组 使用true和false区分两种颜色
        boolean[] visited; // visited用于检测成环

        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            color = new boolean[n];
            visited = new boolean[n];

            // 图不一定联通，所以要遍历每一个子图
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    dfs(graph, v);
                }
            }
            return ok;
        }

        private void dfs(int[][] graph, int v) {
            if (!ok) return; // 如果发现不是连通图了，就停止遍历
            visited[v] = true; // 记录当前遍历节点
            for (int w : graph[v]) {
                if (!visited[w]) {
                    // 相邻节点w没有被访问过
                    // 给w涂上不同于v的颜色
                    // 一个节点的所有邻居涂上同一个颜色，细品
                    color[w] = !color[v];
                    // 继续遍历 w ，递归去给w的邻居涂上颜色
                    dfs(graph, w);
                } else {
                    // 相邻节点已经访问过
                    // 根据v 和 w的颜色判断是否为二分图
                    if (color[w] == color[v]) {
                        // 发现相同，代表不是二分图
                        ok = false;
                    }
                }
            }
        }
    }
}
