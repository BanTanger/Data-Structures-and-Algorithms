package com.bantanger.recur;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class BackPack_01 {
    public static int maxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, bag);
    }

    /**
     * 递归过程
     *
     * @param w     物品重量数组
     * @param v     物品价值数组
     * @param index 指针，0...length - 1范围内自由选择移动
     * @param rest  背包剩余空间 不能小于0
     * @return 母过程:返回index 从 0 到 length - 1 选择货物的最大价值
     * 子过程:如果rest小于0就返回 -1，如果rest达到终止条件就返回 0
     */
    public static int process(int[] w, int[] v, int index, int rest) {
        // base case 1
        if (rest < 0) { // 剩余空间为零，返回 -1 标记
            return -1;
        }
        // base case 2
        if (rest == w.length) { // 终止情况，返回 价值 '0' (没有价值)
            return 0;
        }
        int p1 = process(w, v, index + 1, rest); // 没有选择当前的货物放入背包
        int p2 = -1;
        int p2Next = process(w, v, index + 1, rest - w[index]); // 选择当前的货物加入背包
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }


}
