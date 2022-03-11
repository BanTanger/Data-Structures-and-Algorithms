package com.bantanger.recur;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class FullPermutation {
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (res == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    /**
     * 递归过程，完成N叉树的深度优先遍历
     * @param str 传入的字符数组
     * @param i 指针，用来确定在 i 位置上 有 N - i情况分支
     * @param res 当遍历到最大深度时将记录放入res集合中
     */
    public static void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(i));
        }
        // 如果i没有终止，i 和 i以后的元素都可以放在i位置上
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            process(str, i + 1, res);
            swap(str, i, j);
        }
    }

    public static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
