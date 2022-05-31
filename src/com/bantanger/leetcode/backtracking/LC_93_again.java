package com.bantanger.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/30 23:02
 */
public class LC_93_again {
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            // 没有前导0， 但只有一个0的情况是允许的，意思是遇到0就要标点
            // 最多三叉树，并且三位数必须满足[0, 255]范围
            // 记录当前点的数字，如果超过三但剩下的数据超过了255就回溯。
            if (s.length() > 12) return res; // IP地址最大长度为12
            backtracking(s, 0, 0);
            return res;
        }

        // pointNum用于记录当前标的逗号。
        private void backtracking(String s, int startIndex, int pointNum) {
            // 终止条件：当前逗号达到3.然后校验一下剩下数据的合法性。
            if (pointNum == 3) {
                if (isVaild(s, startIndex, s.length() - 1)) {
                    res.add(s);
                }
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (isVaild(s, startIndex, i)) {
                    s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                    backtracking(s, i + 2, pointNum + 1);
                    s = s.substring(0, i + 1) + s.substring(i + 2);
                } else {
                    break; // 数据校验不成功，跳到下一个位置进行校验
                }
            }
        }

        private boolean isVaild(String s, int l, int r) {
            if (l > r) return false;
            // 不能有非数字，不能以0开头。
            if (s.charAt(l) == '0' && l != r) return false;
            int num = 0;
            for (int i = l; i <= r; i++) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') return false; // 遇到非数字
                num = num * 10 + (s.charAt(i) - '0');
                if (num > 255) return false;
            }
            return true;
        }
    }

    @Test
    public void test() {
        String s = "25525511135";
        new Solution().restoreIpAddresses(s);
    }
}
