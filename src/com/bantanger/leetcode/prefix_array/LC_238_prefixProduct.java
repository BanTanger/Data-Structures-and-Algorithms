package com.bantanger.leetcode.prefix_array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/8 20:22
 */
public class LC_238_prefixProduct {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 创建一个前缀积和一个后缀积
            int n = nums.length;
            int[] prefix = new int[n];
            int[] suffix = new int[n];
            // 注意这里不像前缀和，必须要对元素首进行初始化，
            // 不然默认初始化为0，得到的积就都是0
            prefix[0] = nums[0];
            suffix[n - 1] = nums[n - 1];
            for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
                prefix[i] = prefix[i - 1] * nums[i];
                suffix[j] = suffix[j + 1] * nums[j];
            }
            // answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
            // 其实就是这个元素以前的前缀和 * 以后的后缀和
            nums[0] = suffix[1]; // 新数组的第一个元素就是后缀积第二位元素
            nums[n - 1] = prefix[n - 2]; // 新数组的最后一个元素就是前缀积倒数第二位元素
            for (int i = 1; i < n - 1; i++) {
                nums[i] = prefix[i - 1] * suffix[i + 1]; // 排除本身元素
            }
            return nums;
        }
    }
}
