package com.bantanger.leetcode.Question_of_the_day;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/4 18:08
 */
public class LC_307_2022_04_04 {
    class NumArray {
        private int[] nums;
        private int[] tree;
        private int n;

        public NumArray(int[] nums) {
            int n = nums.length;
            if (n == 0) return;
            this.nums = nums;
            tree = new int[n * 4];
            buildTree(0, 0, n - 1);
        }

        private void buildTree(int node, int start, int end) {
            // 终止条件
            if (start == end) {
                tree[node] = nums[start];
                return;
            }
            int mid = (start + end) >> 1;
            int left_node = 2 * node + 1;
            int right_node = 2 * node + 2;
            // 递归去寻找left_node和right_node的累加和结果
            buildTree(left_node, start, mid);
            buildTree(right_node, mid + 1, end);
            // 当前节点的值等于左右子树值的累加和
            tree[node] = tree[left_node] + tree[right_node];
        }

        public void update(int index, int val) {
            updateTree(index, val, 0, 0, n - 1);
        }

        private void updateTree(int index, int val, int node, int start, int end) {
            if (start > end) return;
            if (start == end) {
                nums[index] = val;
                tree[node] = val;
            } else {
                int mid = (start + end) >> 1;
                int left_node = node * 2 + 1;
                int right_node = node * 2 + 2;
                if (index >= start && index <= mid) { // 左查找
                    updateTree(index, val, left_node, start, mid);
                } else { // 右查找
                    updateTree(index, val, right_node, mid + 1, end);
                }
                tree[node] = tree[left_node] + tree[right_node];
            }
        }

        public int sumRange(int left, int right) {
            return query(left, right, 0, 0, n - 1);
        }

        private int query(int left, int right, int node, int start, int end) {
            // 不在查询的范围返回0即可
            if (left > end || right < start) return 0;
            if (start == end ||
                    (left <= start && right >= end))
                // 到达叶子节点或者落在调查区间内就返回
                return tree[node];
            else {
                int mid = (start + end) >> 1;
                int left_node = node * 2 + 1;
                int right_node = node * 2 + 2;
                int left_res = query(left, right, left_node, start, mid);
                int right_res = query(left, right, right_node, mid + 1, end);
                return left_res + right_res;
            }
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
}
