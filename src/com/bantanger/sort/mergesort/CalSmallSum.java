package com.bantanger.sort.mergesort;

import org.junit.jupiter.api.Test;

/**
 * 求小和问题，给定一个无序数组，遍历一边数组查看当前数据前面是否有比它小的，
 * 如果有就加起来，不断迭代这个过程，最后将所有小和累加返回
 *
 * @author bantanger 半糖
 * @version 1.0
 */
public class CalSmallSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 3, 1, 4};
        int res = calsmallsum(arr);
        System.out.println(res);
    }

    /**
     * 计算部分，
     * 实际上在process完成所有的小和累加，
     * 这里做一个筛选数组的操作
     * @param arr 传入的数组
     * @return 返回计算结果
     */
    public static int calsmallsum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    /**
     * 计算部分，通过递归执行计算，并且将数组排好序
     * @param arr 传入的数组
     * @param L 数组的左边界
     * @param R 数组的有边界
     * @return 在子过程返回当前小和计算结果，
     *         在母过程返回所有小和计算结果
     */
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return process(arr, L, M) + process(arr, M + 1, R) + merge(arr, L, M, R);
    }

    /**
     * 对arr数组进行排序，从无序变成有序
     * @param arr 传入数组
     * @param L 数组左边界
     * @param M 数组中间值
     * @param R 数组有边界
     * @return 在子过程返回部分有序数组
     *         在母过程返回整体有序数组
     */
    public static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }
}
