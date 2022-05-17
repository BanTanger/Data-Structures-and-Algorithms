package com.bantanger.leetcode.sort;

import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/17 15:30
 */
public class LC315 {
    class Solution {
        class Pair{
            int val, index;
            public Pair(int val, int index){
                this.val = val;
                this.index = index;
            }
        }
        // 用于归并的辅助数组
        Pair[] temp;
        // 记录左有序数组在右有序数组有多少个数据
        int[] count;
        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            temp = new Pair[n];
            count = new int[n];
            Pair[] arr = new Pair[n];
            for(int i = 0; i < n; i++) {
                arr[i] = new Pair(nums[i], i);
            }
            sort(arr, 0, n - 1);
            List<Integer> res = new LinkedList<>();
            for(int num : count) res.add(num);
            return res;
        }
        private void sort(Pair[] arr, int lo, int hi){
            if(lo == hi) return ;
            int mid = lo + hi >> 1;
            sort(arr, lo, mid);
            sort(arr, mid + 1, hi);
            marge(arr, lo, mid, hi);
        }
        private void marge(Pair[] arr, int lo, int mid, int hi ){
            for(int i = lo; i <= hi; i++) {
                temp[i] = arr[i];
            }
            int i = lo, j = mid + 1;
            for(int p = lo; p <= hi; p++) {
                if(i == mid + 1) {
                    // 左半部分已经存储完毕
                    arr[p] = temp[j++];
                } else if(j == hi + 1) {
                    arr[p] = temp[i++];
                    count[arr[p].index] += j - mid - 1;
                } else if(temp[i].val > temp[j].val) {
                    arr[p] = temp[j++];
                } else {
                    arr[p] = temp[i++];
                    count[arr[p].index] += j - mid - 1;
                }
            }
        }
    }
}
