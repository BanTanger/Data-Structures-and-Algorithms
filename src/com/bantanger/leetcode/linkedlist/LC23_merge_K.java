package com.bantanger.leetcode.linkedlist;

import java.util.PriorityQueue;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/10 13:04
 */
public class LC23_merge_K {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            // 先创建虚拟头节点
            ListNode dummy = new ListNode(-1), p = dummy;
            // 使用优先级队列，只需要维护最小值就行，就无需使用快排对整个列表进行排序
            // 更何况快排只能对Arrays使用
            PriorityQueue<ListNode> pq = new PriorityQueue<>
                    (lists.length, (o1, o2) -> (o1.val - o2.val));
            // 将列表的头节点放入
            for (ListNode head : lists) {
                if (head != null) {
                    pq.add(head); // 因为优先级队列不能放null，所以要进行非空判断
                }
            }
            // 创建链表
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                p.next = node;
                if (node.next != null) {
                    pq.add(node.next); // 让当前节点的下一个节点入队
                }
                p = p.next;
            }
            return dummy.next;
        }
    }
}
