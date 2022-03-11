package com.bantanger.recur;

import java.util.ArrayList;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class AdvanceFullPermutation {
    // 分支限界法提前去除重复支路
    public static void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(i));
            return;
        }
        boolean[] visit = new boolean[26]; // visit[0 1 ... 25]
        // 创建一个布尔类型的字母数组，用于记录 当前位置的字母是否已经存在了
        // 如果存在就是true，不用管，如果不存在就是false，创建分支
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                // 创建分支，同时将这一号元素记录，用于后续判断是否有重
                swap(str,i,j);
                process(str,i+ 1,res);
                swap(str,i,j);
            }
        }
    }

    public static void swap(char[] str,int i ,int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
