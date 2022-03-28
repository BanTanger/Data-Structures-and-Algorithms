package com.bantanger.leetcode.greedy;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/28 21:24
 */
public class LC_860 {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int[] money = new int[2];
            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == 5) {
                    money[0]++;
                } else if (bills[i] == 10) {
                    money[1]++;
                    if (money[0] > 0) {
                        money[0]--;
                    } else {
                        return false;
                    }
                } else {
                    if (money[1] >= 1 && money[0] >= 1) {
                        money[1]--;
                        money[0]--;
                    } else if (money[0] >= 3) {
                        money[0] -= 3;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
