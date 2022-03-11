package com.bantanger.recur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class AdvanceSubsquence {
    // 不能有重复子串
    public static List<String> subs(String s) {
        char[] str = s.toCharArray(); // 将字符串转化成一个字母集合
        String path = ""; // 默认一开始走的分支是no，定义path为空串
        HashSet<String> set = new HashSet<>();
        process(str, 0, set, path);
        List<String> ans = new ArrayList<>();
        for (String cur : set) {
            ans.add(cur);
        }
        return ans;
    }

    /**
     * 同时也是深度优先遍历
     * @param str   传入字符串字母集合
     * @param index 子过程中index指针此时来到的位置
     * @param set   index从0到length()产生的所有可能情况放入ans中
     * @param path  每一个位置做出的选择，两种情况：yes or no，同时也表示产生的答案，很强
     */
    public static void process(char[] str, int index, HashSet<String> set, String path) {
        // 用HashSet来去重
        if (index == str.length) {
            set.add(path); // 将之前的所有情况加入ans集合中
            return; // 终止情况
        }
        String no = path; // 空串，表示当前走的路径是没有字符的情况
        process(str, index + 1, set, no);

        String yes = path + String.valueOf(str[index]);
        // 表示当前走的路径是有字符的情况，就取出当前index位置对应的字符数组元素。
        process(str, index + 1, set, yes);
    }
}
