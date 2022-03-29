package com.bantanger.leetcode.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/29 10:23
 */
public class LC_406 {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            // 身高从大到小排序，身高相同k小排前面
            Arrays.sort(people, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];
            });
            for(int[] p : people){
                for(int x : p){
                    System.out.print(x + " ");
                }
                System.out.print(",");
            }
            System.out.println();
            LinkedList<int[]> que = new LinkedList<>();

            // 遍历people，以它们的k作为索引，add方法如果碰到同个索引
            // 会优先把后来的索引放在前面，然后当前索引后面的节点索引统统加一
            for (int[] p : people) {
                que.add(p[1], p);

            }

            return que.toArray(new int[people.length][]);
        }
    }

    @Test
    public void test() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        people = new Solution().reconstructQueue(people);
        for(int[] p : people){
            for(int x : p){
                System.out.print(x + " ");
            }
            System.out.print(",");
        }
    }
}
