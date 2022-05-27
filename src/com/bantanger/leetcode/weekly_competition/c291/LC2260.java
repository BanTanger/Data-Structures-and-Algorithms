package com.bantanger.leetcode.weekly_competition.c291;

import java.util.HashMap;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/26 23:45
 */
public class LC2260 {
    class Solution {
        /*遍历一遍数组。使用map记录数值和该数值上一次出现的位置 遍历当前数值
        如果是第一次出现则直接存入map，如果之前出现则计算距离，
        判断是否更新ans，同时更新该数值出现的位置。 最后判断ans是否被更新，
        若没有更新说明没有满足的解，返回-1；否则返回ans。
        只需要相邻的两个相同的数值间距一段一段计算就可以了，
        因为最短的只能在挨着的两个之间出现*/
        public int minimumCardPickup(int[] cards) {
            int ans = 100001;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < cards.length; i++) {
                if (map.containsKey(cards[i])) {
                    ans = ans <= i - map.get(cards[i]) + 1 ? ans : i - map.get(cards[i]) + 1;
                }
                map.put(cards[i], i);
            }
            return ans == 100001 ? -1 : ans;
        }
    }
}
