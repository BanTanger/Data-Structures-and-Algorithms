package com.bantanger.leetcode.Question_of_the_day.may.data_2022_05_06;

import java.util.*;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/6 17:27
 */
public class LC_933 {
    class RecentCounter3 {

        //队列，保证队列中时间长度小于等于3000
        Deque<Integer> deque;

        public RecentCounter3() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            deque.offerLast(t);
            while (deque.getLast() - deque.getFirst() > 3000) {
                deque.pollFirst();
            }
            return deque.size();
        }

    }

    class RecentCounter2 {
        private Queue<Integer> que;

        public RecentCounter2() {
            que = new LinkedList<>();
        }

        public int ping(int t) {
            while (!que.isEmpty()) {
                int time = que.element();
                if (time < t - 3000) {
                    que.poll(); // 因为t逐步增大，如果队列前面的数不在范围之内就踢出队列
                } else {
                    break;
                }
            }
            que.offer(t);
            return que.size();
        }
    }

    class RecentCounter {
        private int count;
        private List<Integer> req;

        public RecentCounter() {
            count = 0; // 初始化请求数为0
            req = new ArrayList<>(); // 创建一个请求列表
        }

        public int ping(int t) {
            count = 0;
            req.add(t);
            // 遍历列表，在范围区间的东西就拿出来
            for (int request : req) {
                if (request >= (t - 3000) && request <= t) {
                    count++;
                }
            }
            return count;
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
