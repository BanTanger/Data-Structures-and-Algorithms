package com.bantanger.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/20 8:29
 */
public class LC_93_String {
    class Solution {
        List<String> result = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            if (s.length() > 12) return result; // 部分剪枝
            backtracking(s, 0, 0);
            return result;
        }

        public void backtracking(String s, int startIndex, int pointNum) {
            if (pointNum == 3) { // 逗号数量为3.复原ip地址的任务结束
                //判断第四段字串是否合法，合法放入result
                if (isValue(s, startIndex, s.length() - 1)) {
                    result.add(s);
                }
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (isValue(s, startIndex, i)) {
                    s = s.substring(0, i + 1) + "." + s.substring(i + 1); // 在验证合法的子串后面插入点
                    pointNum++;
                    backtracking(s, i + 2, pointNum); // 插入点之后下一个子串起始位置为 i + 2
                    pointNum--;
                    s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉点
                } else {
                    break;
                }
            }
        }

        private boolean isValue(String s, int start, int end) {
            if (start > end) {
                return false;
            }

            if (s.charAt(start) == '0' && start != end) {
                return false; // 不允许开头数字为零
            }

            int num = 0;
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                    return false;
                }
                num = num * 10 + (s.charAt(i) - '0');
                if (num > 255) { // 不允许num > 255
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void test(){
        String s = "25525511135";
        new Solution().restoreIpAddresses(s);
    }
}
