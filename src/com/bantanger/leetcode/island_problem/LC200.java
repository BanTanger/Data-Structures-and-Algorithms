package com.bantanger.leetcode.island_problem;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 11:42
 */
public class LC200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int n = grid.length, m = grid[0].length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 找到岛屿，记录加一
                    if (grid[i][j] == '1') {
                        res++;
                        // 使用dfs将该岛屿淹没
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        private void dfs(char[][] grid, int i, int j) {
            int n = grid.length, m = grid[0].length;
            if (i < 0 || j < 0 || i >= n || j >= m) return;
            if (grid[i][j] == '0') return; // 该岛屿已经被水淹没，直接返回

            // 将（i，j）变为海水
            grid[i][j] = '0';
            // 淹没(i,j)附近的所有岛屿
            for (int[] dir : dirs) {
                int next_i = i + dir[0];
                int next_j = j + dir[1];
                dfs(grid, next_i, next_j);
            }
        }
    }
}
