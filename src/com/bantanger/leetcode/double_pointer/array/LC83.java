package com.bantanger.leetcode.double_pointer.array;

import com.bantanger.leetcode.linkedlist.ListNode;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 10:16
 */
public class LC83 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode fast, slow;
            fast = slow = head;
            while (fast != null) {
                if (fast.val != slow.val) {
                    // nums[slow] = nums[fast]
                    slow.next = fast;
                    // slow++
                    slow = slow.next;
                }
                // fast++
                fast = fast.next;
            }
            // 断开后面链表的连接
            slow.next = null;
            return head;
        }
    }
}
