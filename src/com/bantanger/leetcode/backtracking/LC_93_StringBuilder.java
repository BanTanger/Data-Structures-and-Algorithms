package com.bantanger.leetcode.backtracking;

import org.junit.jupiter.api.Test;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/3/20 8:30
 */
public class LC_93_StringBuilder {
    class Solution {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(); 
        // 使用StringBuilder优化字符串拼接
        // 使用String无法做到拼接，底层是不断开辟新的空间然后把原先字符串拷贝一份

        public List<String> restoreIpAddresses(String s) {
            backtracking(s, 0, 0);
            return result;
        }

        // number表示stringBuilder中的ip段的数量
        public void backtracking(String s, int start, int number) {
            // start等于s的长度并且ip段数为4，就加入结果集，并返回
            if (start == s.length() && number == 4) {
                // stringBuilder本质装的是对象变量，需要使用toString方法转换成String类型
                result.add(stringBuilder.toString());
                return;
            }
            // 如果start等于s的长度但是ip段数不为4，直接结束，返回空
            if (start == s.length() || number == 4) return;
            // 两个终止条件考虑周到

            // 剪枝：ip段的最大长度是3.并且每一个ip段都要满足[0,255]的区间
            // 利用 start 同层不变的特性,i - start < 3 框定最多能分割字符串的长度
            // 将子串转换成整型变量,判断是否在[0,255]
            for (int i = start; i < s.length() &&
                    i - start < 3 &&
                    Integer.parseInt(s.substring(start, i + 1)) >= 0 &&
                    Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
                // 如果ip段数大于1，并且第一位是0，直接continue过滤
                if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                    continue;
                }
                // substring方法是左闭右开的 [start,i + 1)
                stringBuilder.append(s.substring(start, i + 1));
                // 当stringBuilder里的ip段数小于3时，才添加一个点，(for循环条件中已经将字符串切割)
                // 如果等于3，说明已经有3段了，最后不需要加点
                if (number < 3) {
                    stringBuilder.append(".");
                }
                number++;
                backtracking(s, i + 1, number);
                number--; // 回溯
                // 删除当前stringBuilder最后一个网段
                stringBuilder.delete(start + number, i + number + 2);
            }
        }
    }

    @Test
    public void Test(){
        String s = "25525511135";
        Solution solution = new Solution();
        solution.restoreIpAddresses(s);
    }
}
