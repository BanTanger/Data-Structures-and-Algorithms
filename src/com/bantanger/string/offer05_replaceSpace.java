package com.bantanger.string;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/28 18:16
 */
public class offer05_replaceSpace {
    class Solution {
        public String replaceSpace(String s) {
            StringBuffer sb = new StringBuffer();
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] != ' ') {
                    sb.append(ch[i] + "");
                } else {
                    sb.append("%20");
                }
            }
            return sb.toString();
        }
    }
}
