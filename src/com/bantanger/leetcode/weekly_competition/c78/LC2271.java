package com.bantanger.leetcode.weekly_competition.c78;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/24 21:52
 */
public class LC2271 {
    class Solution {
        public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
            Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
            int preSum[] = new int[tiles.length + 1];
            for (int i = 1; i <= tiles.length; i++) {
                preSum[i] = preSum[i - 1] + tiles[i - 1][1] - tiles[i - 1][0] + 1;
            }
            int ans = 0;
            for (int i = 0; i < tiles.length; i++) {
                if (tiles[i][0] + carpetLen > tiles[tiles.length - 1][1]) {
                    ans = Math.max(ans, preSum[tiles.length] - preSum[i]);
                    break;
                } else {
                    //寻找地毯的右端点，最近不超过哪一个分段的右端
                    int l = i, r = tiles.length - 1;
                    while (l < r) {
                        int mid = (l + r) >> 1;
                        if (tiles[i][0] + carpetLen - 1 <= tiles[mid][1]) {
                            r = mid;
                        } else {
                            l = mid + 1;
                        }
                        if (l == r - 1) {
                            if (tiles[i][0] + carpetLen - 1 <= tiles[l][1]) {
                                r = l;
                            }
                            break;
                        }
                    }
                    if (tiles[i][0] + carpetLen <= tiles[r][0]) {
                        ans = Math.max(ans, preSum[r] - preSum[i]);
                    } else {
                        ans = Math.max(ans, preSum[r] - preSum[i] + tiles[i][0] + carpetLen - tiles[r][0]);
                    }
                }
            }
            return ans;
        }
    }
}
