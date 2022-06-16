package com.bantanger.leetcode.double_pointer.two_points;

import java.util.Arrays;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/16 9:53
 */
public class LC532 {
    class Solution {
        public int findPairs(int[] nums, int k) {
            /* 为什么使用二分？我们发现这个问题具有二段性
                跳过重复元素的方法：双指针跳过，哈希表记录
                */
            Arrays.sort(nums);
            int n = nums.length;
            int res = 0;
            for (int i = 0; i < n - 1; ) {
                int t = nums[i] + k; // 设置i指针从0游走到n-1
                int l = i + 1, r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1; // 猜测mid就是所寻找数据的下标
                    if (nums[mid] > t) r = mid - 1; // mid猜测大了，r往左走
                    else l = mid; // mid猜测小了，l往右走
                }
                // 只有当nums[i] - nums[l] == k 才记录到res
                res += nums[l] == t ? 1 : 0;
                // 双指针跳过重复元素
                int j = i + 1;
                while (j < n && nums[j] == nums[i]) j++;
                i = j;
            }
            return res;
        }
    }
}
