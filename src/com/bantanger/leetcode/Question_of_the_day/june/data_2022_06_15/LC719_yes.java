package com.bantanger.leetcode.Question_of_the_day.june.data_2022_06_15;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/15 11:37
 */
public class LC719_yes {
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums); // 对数组排序，左最小，右最大
            int l = 0, r = nums[n - 1] - nums[0];
            // 双指针加二分
            while (l < r) {
                /*
                * 为什么二分，怎么二分：
                * 我们随机选取（mid）作为答案，检查距离mid是否是第k小，
                * 如果check的值超过了k，就代表我们猜测太大了,应该把猜测值往左移动（r = mid)
                * 反之就是猜测小了，应该把猜测值往右移动（l = mid + 1)
                * */
                int mid = l + r >> 1;
                if (check(mid, nums) >= k) r = mid;
                else l = mid + 1;
            }
            return r;
        }

        private int check(int x, int[] nums) {
            int n = nums.length;
            int count = 0;
            for (int i = 0, j = 1; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= x) j++;
                count += j - i - 1;
            }
            return count;
        }
    }
}
