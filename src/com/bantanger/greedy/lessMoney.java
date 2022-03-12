package com.bantanger.greedy;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class lessMoney {
    public static int LessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
}
