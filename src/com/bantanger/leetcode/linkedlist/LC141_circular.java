package com.bantanger.leetcode.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/10 14:53
 */
public class LC141_circular {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // 设置快慢指针，快指针走两步，慢指针走一步
            // 如果快指针出现null就代表无环，如果快指针与慢指针相遇代表有环。
            ListNode fast, slow;
            fast = slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                // 快慢指针相遇，说明链表成环
                if (fast == slow) return true;
            }
            // 能跳出while循环，说明fast此时已经移动到null，链表因此不成环
            return false;
        }
    }
}
