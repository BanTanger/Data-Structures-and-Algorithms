package com.bantanger.leetcode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 17:01
 */
public class LC207_BFS {
    class Solution {
        boolean[] onPath, visited;
        boolean hasCycle = false;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 建立图的邻接表
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            // BFS
            // 根据题目给出的课程节点构建每个节点的入度表
            int[] help = new int[numCourses];
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                help[to]++; // 对目的节点的邻居进行入度统计
            }

            // 构建队列
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                // 寻找入度为0的节点加入队列作为拓扑排序的起始位置
                if (help[i] == 0) {
                    q.offer(i);
                }
            }
            int count = 0;
            while (!q.isEmpty()) {
                // 将当前队列入度为0的节点弹出
                int cur = q.poll();
                count++; // 记录弹出来的节点
                // 当前节点的邻居全部减一
                for (int next : graph[cur]) {
                    help[next]--;
                    if (help[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            return count == numCourses;
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
