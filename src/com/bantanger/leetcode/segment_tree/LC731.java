package com.bantanger.leetcode.segment_tree;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/7/19 14:58
 */
public class LC731 {
    class MyCalendarTwo {
        /*https://leetcode.cn/problems/my-calendar-ii/solution/by-lfool-nodi/*/
        public MyCalendarTwo() {
        }

        public boolean book(int start, int end) {
            if (query(root, 0, N, start, end - 1) == 2) return false;
            update(root, 0, N, start, end - 1, 1);
            return true;
        }

        // 线段树模板
        class Node {
            Node left, right; // 左右孩子节点
            int val, add; // 当前节点值，懒惰标记值
        }

        private int N = (int) 1e9;
        private Node root = new Node();

        public void update(Node node, int start, int end, int l, int r, int val) {
            if (l <= start && end <= r) {
                node.val += val;
                node.add += val;
                return;
            }
            pushDown(node); // 下推节点，更新子节点和懒惰标记
            int mid = (start + end) >> 1;
            if (l <= mid) update(node.left, start, mid, l, r, val);
            if (r > mid) update(node.right, mid + 1, end, l, r, val);
            pushUp(node); // 上推节点，更新当前节点的值
        }

        public int query(Node node, int start, int end, int l, int r) {
            if (l <= start && end <= r) return node.val;
            pushDown(node);
            int mid = (start + end) >> 1, ans = 0;
            if (l <= mid) ans = query(node.left, start, mid, l, r);
            if (r > mid) ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
            return ans;
        }

        private void pushUp(Node node) {
            node.val = Math.max(node.left.val, node.right.val);
        }

        private void pushDown(Node node) {
            // 动态开点
            if (node.left == null) node.left = new Node();
            if (node.right == null) node.right = new Node();
            if (node.add == 0) return; // 懒惰标记为0，代表当前节点不需要更新
            node.left.val += node.add;
            node.right.val += node.add;
            // 将node节点的懒惰标记推给左右子节点
            node.left.add += node.add;
            node.right.add += node.add;
            node.add = 0; // 消除node节点的懒惰标记
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
}
