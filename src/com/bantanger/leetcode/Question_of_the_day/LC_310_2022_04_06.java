package com.bantanger.leetcode.Question_of_the_day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/9 12:13
 */
public class LC_310_2022_04_06 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) { // 只有一个节点情况，标记成0返回，题目规定
            res.add(0);
            return res;
        }

        // 创建数组存放每个节点的度（邻居数）
        int[] degree = new int[n];
        // 创建 度表
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // 遍历题目给定的无向边列表，建立 度表
        for (int[] edge : edges) {
            int a = edge[0]; // 节点 1
            int b = edge[1]; // 节点 2
            // 每遍历一次就增加相互连接节点的度
            degree[a]++;
            degree[b]++;

            // 建立树，（度表关系）
            if (map.get(a) == null) {
                map.put(a, new ArrayList<Integer>()); // key : 节点 value : 所有邻居
            }
            if (map.get(b) == null) {
                map.put(b, new ArrayList<Integer>()); // key : 节点 value : 所有邻居
            }

            map.get(a).add(b);
            map.get(b).add(a);
        }

        // Queue队列存放所有度为1的节点
        LinkedList<Integer> leafNodes = new LinkedList<>();

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                leafNodes.add(i);
            }
        }

        while (leafNodes.size() > 0) {
            res.clear(); // 只要进入循环就将res结果列表清空，为了存放最终的度为1的节点，也是中心节点
            int size = leafNodes.size(); // 这里因为队列会弹出元素改变长度，所以提前记录当前长度
            for (int i = 0; i < size; i++) {
                int leaf = leafNodes.poll();
                res.add(leaf); // 将度为1的节点放入结果数组中
                ArrayList<Integer> neighbors = map.get(leaf); // 拿出当前节点的所有邻居
                for (int neighbor : neighbors) {
                    degree[neighbor]--; // 邻居的度减一
                    if (degree[neighbor] == 1) {
                        leafNodes.add(neighbor); // 如果减少到1时就放入队列继续循环。
                    }
                }
            }
        }
        return res;
    }
}
