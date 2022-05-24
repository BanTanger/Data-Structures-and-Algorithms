package com.bantanger.leetcode.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 15:39
 */
public class LC207_DFS {
    class Solution {
        boolean[] visited;
        boolean[] onPath;
        boolean hasCycle = false;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 经典环检测题目
            // 把问题转换成图，判断是否有环

            // 建图函数
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);

            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];
        /* 图中并不是所有节点都相连，
        所以要用一个 for 循环将所有节点都作为起点
        调用一次 DFS 搜索算法 */
            for (int i = 0; i < numCourses; i++) {
                dfs(graph, i);
            }
            return !hasCycle;
        }

        // 从节点s开始DFS遍历，将遍历过的节点记为true
        public void dfs(List<Integer>[] graph, int s) {
            if (onPath[s]) hasCycle = true;
            // 已经记录过的节点 或者检测出成环，就跳过
            if (visited[s] || hasCycle) return;
            // 将s标记成已遍历节点
            visited[s] = true;
            // 开始遍历s节点
            onPath[s] = true;
            for (int t : graph[s]) {
                dfs(graph, t);
            }
            // 节点s遍历完成
            onPath[s] = false;
        }

        public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            // 图中共有numCourses个节点
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                // 每一个课程设置一行邻接表
                graph[i] = new LinkedList<>();
            }
            // 根据题目给的访问顺序构建图
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                // 添加一条从 from 指向 to 的有向边
                graph[from].add(to);
                // 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
            }
            return graph;
        }
    }
}
