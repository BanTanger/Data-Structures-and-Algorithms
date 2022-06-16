package com.bantanger.leetcode.double_pointer.two_points;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/16 9:08
 */
public class LC1011 {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            // 划分数组类问题。
            // 怎么使用二分呢，我们可以这样想，
            // 如果想要让所有货物在一天内被运载，那么船的最低承重应该是所有货物的和
            // 如果想要让所有货物最慢被运载，那么船的承重就应该是货物的最大值
            // 这个就是左右边界
            int l = 0, r = 0;
            for(int x : weights) {
                l = Math.max(l, x);
                r += x;
            }
            while(l < r) {
                int mid = l + r >> 1;
                int cnt = 1; // 需要的天数记录
                int sum = 0;
                for(int w : weights) {
                    if(sum + w > mid) {
                        sum = 0;
                        cnt++;
                    }
                    sum += w;
                    // System.out.println(sum);
                }
                if(cnt > days) l = mid + 1;
                else r = mid;
            }
            return r;
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,1,1};
        new Solution().shipWithinDays(nums, 4);
    }
}
