package com.bantanger.leetcode.Question_of_the_day;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/20 22:49
 */
public class LC_388_2022_04_20 {
    class Solution {
        public int lengthLongestPath(String s) {
            Map<Integer, String> map = new HashMap<>();
            int n = s.length();
            String ans = null;
            for (int i = 0; i < n; ) {
                int level = 0;
                while (i < n && s.charAt(i) == '\t' && ++level >= 0) i++;
                int j = i;
                boolean isDir = true; // 通过设置布尔变量来判断当前目录是文件还是文件夹
                while (j < n && s.charAt(j) != '\n') {
                    if (s.charAt(j++) == '.') isDir = false; // 遇到文件
                }
                String cur = s.substring(i, j);
                String prev = map.getOrDefault(level - 1, null);
                String path = prev == null ? cur : prev + "/" + cur;
                if (isDir) map.put(level, path);
                else if (ans == null || path.length() > ans.length()) ans = path;
                i = j + 1;
            }
            return ans == null ? 0 : ans.length();
        }
    }
}
