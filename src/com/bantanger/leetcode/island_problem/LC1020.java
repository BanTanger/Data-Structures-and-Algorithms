package com.bantanger.leetcode.island_problem;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/22 13:11
 */
public class LC1020 {
    class Solution {
        public int numEnclaves(int[][] grid) {
            // 这题和LC1254是一样的，直接套用模板解了
            // 首先淹没上下左右边界的边界岛屿，
            // （注意这里dfs如果边界岛屿连接封闭岛屿会把相连的所有岛屿都给淹没）
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                dfs(grid, i, 0);
                dfs(grid, i, n - 1);
            }
            for (int j = 0; j < n; j++) {
                dfs(grid, 0, j);
                dfs(grid, m - 1, j);
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res++;
                    }
                }
            }
            return res;
        }

        private void dfs(int[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n) return;
            if (grid[i][j] == 0) return;

            grid[i][j] = 0;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}
