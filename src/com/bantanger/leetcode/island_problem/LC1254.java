package com.bantanger.leetcode.island_problem;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 12:51
 */
public class LC1254 {
    class Solution {
        public int closedIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int j = 0; j < n; j++) {
                // 把靠上边的岛屿淹没
                dfs(grid, 0, j);
                // 把靠下边的岛屿淹没
                dfs(grid, m - 1, j);
            }

            for (int i = 0; i < m; i++) {
                // 把靠左边的岛屿淹没
                dfs(grid, i, 0);
                // 把靠右边的岛屿淹没
                dfs(grid, i, n - 1);
            }

            // 遍历grid，现在剩下的岛屿全部都是封闭的，直接记录岛屿即可
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private void dfs(int[][] grid, int i, int j) {
            int n = grid.length, m = grid[0].length;
            if (i < 0 || j < 0 || j >= m || i >= n) return; // 边界情况处理干净
            if (grid[i][j] == 1) return; // 如果岛屿已经被淹没了，就直接返回

            // 进入（i，j）
            grid[i][j] = 1; // 将这个岛屿淹没
            for (int[] dir : dirs) {
                int next_i = i + dir[0];
                int next_j = j + dir[1];
                dfs(grid, next_i, next_j);
            }
        }
    }
}
