package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_23;

import java.util.*;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/23 19:59
 */
public class LC675 {
    class Solution {
        int m, n;
        int[][] f;
        int[][] DIR = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int cutOffTree(List<List<Integer>> forest) {
            // 思路：每次从树中选择一个最低的，看从当前位置（初始位置为 (0,0)）到该最低树位置的距离
            m = forest.size();
            n = forest.get(0).size();
            f = new int[m][n];
            List<int[]> tree2Cut = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    f[i][j] = forest.get(i).get(j);
                    if (f[i][j] > 1) {
                        tree2Cut.add(new int[]{f[i][j], i, j});
                    }
                }
            }
            // 按照树的高度从低到高排序
            Collections.sort(tree2Cut, (o1, o2) -> o1[0] - o2[0]);

            if (f[0][0] == 0) return -1;
            int xPrev = 0, yPrev = 0;
            int ans = 0;
            // 依次取出当前高度最低的树
            for (int[] curr : tree2Cut) {
                int distance = bfs(xPrev, yPrev, curr[1], curr[2]); // 求从当前位置（起始位置为(0, 0)）到该最低树的距离
                if (distance == -1) return -1;
                ans += distance;
                // 将当前树的位置更新为下一次的起始位置
                xPrev = curr[1];
                yPrev = curr[2];
            }

            return ans;
        }

        private boolean inForest(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }

        // 求从 (xStart, yStart) 到 (xEnd, yEnd) 的最短距离（BFS 第一次到达即为最短距离）
        private int bfs(int xStart, int yStart, int xEnd, int yEnd) {
            if (xStart == xEnd && yStart == yEnd) return 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{xStart, yStart});
            boolean[][] visited = new boolean[m][n];
            visited[xStart][yStart] = true;
            int steps = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                steps++;
                for (int i = 0; i < size; i++) {
                    int[] curr = queue.poll();
                    int x = curr[0], y = curr[1];

                    for (int[] dir : DIR) {
                        int xNew = x + dir[0], yNew = y + dir[1];
                        if (xNew == xEnd && yNew == yEnd) return steps;
                        // 确保新加入的必须是树或者是空地
                        if (inForest(xNew, yNew) && !visited[xNew][yNew] && f[xNew][yNew] > 0) {
                            queue.offer(new int[]{xNew, yNew});
                            visited[xNew][yNew] = true;
                        }
                    }
                }
            }
            // 遍历完也没到达 (xEnd, yEnd)，返回 -1
            return -1;
        }
    }
}
