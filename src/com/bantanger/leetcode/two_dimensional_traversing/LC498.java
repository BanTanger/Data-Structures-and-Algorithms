package com.bantanger.leetcode.two_dimensional_traversing;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/14 9:44
 */
public class LC498 {
    class Solution {
        public int[] findDiagonalOrder(int[][] g) {
            int n = g.length, m = g[0].length, cnt = n * m;
            int[] ans = new int[cnt];
            int x = 0, y = 0, dir = 1, idx = 0;
            while (idx != cnt) {
                ans[idx++] = g[x][y]; /*首元素先处理*/
                int nx = x, ny = y;
                if (dir == 1) { /*方向向上走*/
                    nx = x - 1; ny = y + 1;
                    System.out.println("dir=1" + " " + nx + " " + ny);
                } else { /*方向向下走*/
                    nx = x + 1; ny = y - 1;
                    System.out.println("dir=-1" + " " + nx + " " + ny);
                }
                /*如果有越界情况并且当前没有遍历完所有元素*/
                if (idx < cnt && (nx < 0 || nx >= n || ny < 0 || ny >= m)) {
                    if (dir == 1) { /*调整x,y的范围*/
                        nx = y + 1 < m ? x : x + 1; /*调整x，查看y是否越界，如果没有越界*/
                        ny = y + 1 < m ? y + 1 : y;
                        System.out.println("    dir=1" + " " + nx + " " + ny);
                    } else {
                        nx = x + 1 < n ? x + 1 : x;
                        ny = x + 1 < n ? y : y + 1;
                        System.out.println("    dir=-1" + " " + nx + " " + ny);
                    }
                    dir *= -1;
                }
                x = nx; y = ny;
            }
            return ans;
        }
    }


}
