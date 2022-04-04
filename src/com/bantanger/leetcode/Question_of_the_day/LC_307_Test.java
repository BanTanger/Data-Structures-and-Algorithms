package com.bantanger.leetcode.Question_of_the_day;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/4 19:26
 */
public class LC_307_Test {
    private void buildTree(int[] nums, int[] tree, int node, int start, int end) {
        // 终止条件
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = start + end >> 1;
        // 根据根节点数据下标确定左右子树的节点下标
        int leftNode = 2 * node + 1;
        int rightNode = 2 * node + 2;
        // 递归求得左右子树的数据值，递归从宏观而言就是求得根节点的左右子树值
        buildTree(nums, tree, leftNode, start, mid); // 递归查找左子树，区间 start 到 mid 范围
        buildTree(nums, tree, rightNode, mid + 1, end); // 递归查找右子树，区间 mid + 1 到 end 范围
        tree[node] = tree[leftNode] + tree[rightNode]; // 宏观而言就是求得根节点的值
    }

    private void updateTree(int[] nums, int[] tree, int node,
                            int index, int val, int start, int end) {
        if (start == end) { // 找到要修改的节点
            nums[index] = val;
            tree[node] = val;
        } else {
            int mid = start + end >> 1;
            int leftNode = 2 * node + 1;
            int rightNode = 2 * node + 2;
            if (index <= mid && index >= start) { // 左查找
                updateTree(nums, tree, leftNode, index, val, start, mid);
            } else { // 右查找
                updateTree(nums, tree, rightNode, index, val, mid + 1, end);
            }
            tree[node] = tree[leftNode] + tree[rightNode]; // 更改完值后记得将相关父节点更新
        }
    }

    private int queryTree(int[] nums, int[] tree, int node,
                          int L, int R, int start, int end) {
        System.out.println("start = " + start);
        System.out.println("end   = " + end);
        System.out.println();
        if (R < start || L > end) return 0; // 调查区间不在范围内，返回0
        else if (start == end ||
                L <= start && R >= end) return tree[node];
        else {
            int mid = start + end >> 1;
            int leftNode = 2 * node + 1;
            int rightNode = 2 * node + 2;
            int sumLeft = queryTree(nums, tree, leftNode, L, R, start, mid);
            int sumRight = queryTree(nums, tree, rightNode, L, R, mid + 1, end);
            return sumLeft + sumRight;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        int[] tree = new int[nums.length * 4];
        new LC_307_Test().buildTree(nums, tree, 0, 0, nums.length - 1);
        for (int num : tree) {
            System.out.print(num + " ");
        }

        System.out.println();

        new LC_307_Test().updateTree(nums, tree, 0, 4, 6, 0, nums.length - 1);
        for (int num : tree) {
            System.out.print(num + " ");
        }

        System.out.println();

        int i = new LC_307_Test().queryTree(nums, tree, 0, 2, 5, 0, nums.length - 1);
        System.out.println(i);
    }
}
