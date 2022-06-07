package com.bantanger.leetcode.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/6 22:05
 */
public class LC148_Merge {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        ListNode dummy;

        public ListNode sortList(ListNode head) {
            return head == null ? null : process(head);
        }

        private ListNode process(ListNode head) {
            if (head.next == null) return head;
            // 归并排序, 利用双指针找到中间节点
            ListNode fast = head, slow = head, p = null;
            while (fast != null && fast.next != null) {
                p = slow;
                fast = fast.next.next; // 有可能移动不到末尾
                slow = slow.next;
            }
            // if(fast.next != null) { // 移动fast到末尾
            //     fast = fast.next;
            // }
            p.next = null;
            // 当前slow指向的是链表的中间节点
            ListNode L = process(head);
            ListNode R = process(slow);
            return marge(L, R);
        }

        private ListNode marge(ListNode L, ListNode R) {
            dummy = new ListNode(-1);
            // 排序加合并部分
            ListNode cur = dummy;
            while (L != null && R != null) {
                if (L.val > R.val) {
                    cur.next = R;
                    cur = cur.next;
                    R = R.next;
                } else {
                    cur.next = L;
                    cur = cur.next;
                    L = L.next;
                }
            }
            if (L != null) {
                cur.next = L;
            }
            if (R != null) {
                cur.next = R;
            }
            return dummy.next;
        }
    }
}
