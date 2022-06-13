package com.bantanger.leetcode.sliding_window;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/13 18:12
 */
public class LC904 {
    class Solution {
        public int totalFruit(int[] fruits) {
            int n = fruits.length;
            int l = 0, r = 1, max = 1, mark = 0;
            while (r < n) {
                while (r < n && fruits[l] == fruits[r]) {
                    r++;
                    max = Math.max(max, r - l);
                }
                // 出现不同的数
                mark = r;
                while (r < n && (fruits[l] == fruits[r]
                        || fruits[mark] == fruits[r])) {
                    r++;
                    max = Math.max(max, r - l);
                }
                // 左指针往右缩
                l = r - 1; // 左指针移动到右指针前一位
                while (l > 0 && fruits[l - 1] == fruits[l]) l--;
            }
            return max;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,1};
        new Solution().totalFruit(nums);
    }
}
