package com.bantanger.leetcode.linkedlist;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/10 15:54
 */
public class LC160_intersect {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 为两个链表的头节点分别设置两个指针变量，
            // 当p1走完了就跳到p2，或者当p2走完了就跳到p1
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                p1 = p1 == null ? headB : p1.next;
                p2 = p2 == null ? headA : p2.next;
            }
            // 跳出循环代表p1 == p2，即找到第一个相交点
            return p1;
        }
    }
}
