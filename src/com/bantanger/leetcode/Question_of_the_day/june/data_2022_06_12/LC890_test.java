package com.bantanger.leetcode.Question_of_the_day.june.data_2022_06_12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/6/12 16:30
 */
public class LC890_test {
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> res = new ArrayList<>();
            // 创建两个哈希表进行映射
            int[] used = new int[130];
            int[] map = new int[130];
            for (String word : words) {
                // 哈希表进行初始化，一个单词可能对应两种以上的映射情况
                // 所以要把初始化放在循环内部不断更新
                Arrays.fill(map, -1);
                Arrays.fill(used, 0);
                // 初始化
                boolean ok = true;
                for (int i = 0; i < word.length(); i++) {
                    char s = word.charAt(i), pat = pattern.charAt(i);
                    // 对word的每一个字符进行相应映射
                    if (map[s] == -1 && used[pat] == 0) {
                        map[s] = pat; // 做映射
                        used[pat] = 1; // 这个字符已经被使用过了
                    } else if (map[s] != pat) {
                        ok = false;
                        break;
                    }
                }
                if (ok) { // 能成功映射
                    // 把结果放在列表里
                    res.add(word);
                }
            }
            return res;
        }
    }

    @Test
    public void test() {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        new Solution().findAndReplacePattern(words, pattern);
    }
}
