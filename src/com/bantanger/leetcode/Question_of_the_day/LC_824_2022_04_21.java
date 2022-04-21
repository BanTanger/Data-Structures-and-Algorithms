package com.bantanger.leetcode.Question_of_the_day;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/21 23:37
 */
public class LC_824_2022_04_21 {
    class Solution {
        public String toGoatLatin(String sentence) {
            // 先拆分字符串
            String[] cs = sentence.split(" ");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < cs.length; i++) {
                String str = cs[i];
                // 元音开头
                if (str.charAt(0) == 'a' || str.charAt(0) == 'e' ||
                        str.charAt(0) == 'i' || str.charAt(0) == 'o' ||
                        str.charAt(0) == 'u') {
                    sb.append(cs[i] + "ma");
                } else {
                    char temp = cs[i].charAt(0);
                    String c = cs[i].substring(1) + temp;
                    sb.append(c + "ma");
                }
                int count = 1 + i; // 通过减去索引大小的方式完成记录
                while (count-- > 0) {
                    sb.append("a");
                }
                sb.append(" ");
            }
            return sb.toString().trim();
        }
    }
    @Test
    public void test(){
        String sentence = "I speak Goat Latin";
        System.out.println(new Solution().toGoatLatin(sentence));
    }
}
