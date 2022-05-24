package com.bantanger.leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 16:08
 */
public class LC210_DFS {
    class Solution {
        // 记录后序遍历结果
        List<Integer> postorder = new ArrayList<>();
        // 记录是否成环
        boolean[] onPath, visited;
        boolean hasCycle;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];
            // 遍历图
            for (int i = 0; i < numCourses; i++) {
                dfs(graph, i);
            }
            // 有环图无法进行拓扑排序
            if (hasCycle) {
                return new int[]{};
            }
            // 逆后序遍历结果即为拓扑排序结果
            Collections.reverse(postorder);
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = postorder.get(i);
            }
            return res;
        }

        public void dfs(List<Integer>[] graph, int s) {
            if (onPath[s]) hasCycle = true; // 发现成环
            if (visited[s] || hasCycle) return; // 发现遍历过或者已经成环就跳过

            visited[s] = true;
            onPath[s] = true;
            for (int t : graph[s]) {
                dfs(graph, t);
            }
            postorder.add(s);
            onPath[s] = false;
        }

        public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }
    }
}
