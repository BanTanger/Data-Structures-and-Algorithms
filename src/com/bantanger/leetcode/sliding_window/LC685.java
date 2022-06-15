package com.bantanger.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/15 21:58
 */

/*
    给定一个 排序好 的数组 arr ，两个整数 k 和 x ，
    从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。

    整数 a 比整数 b 更接近 x 需要满足：
        |a - x| < |b - x| 或者
        |a - x| == |b - x| 且 a < b

        输入：arr = [1,2,3,4,5], k = 4, x = 3
        输出：[1,2,3,4]
*/
public class LC685 {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int n = arr.length;
            int l = 0, r = n - 1;
            while (r - l >= k) { // 滑动窗口，限制窗口大小为k长度
                if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) l++;
                /* 因为已经保证数组是单调了，所以arr[r] 必然会大于 arr[l]
                * 如果arr[r] - x 小于0, 说明*/
                else r--;
            }
            List<Integer> res = new ArrayList<>();
            while (l <= r) {
                res.add(arr[l++]);
            }
            return res;
        }
    }
}
