package com.bantanger.sort.mergesort;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 47, 3, 1, 6, 7, 4, 1, 9, 8};
        int[] arr2 = {};
        process(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序的“归”过程
     * @param arr 传入的数组
     * @param L 传入数组的左边界
     * @param R 传入数组的右边界
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    /**
     * 归并排序的“并”过程
     * @param arr 传入的数组
     * @param L 传入数组的左边界
     * @param M 传入数组的中间值
     * @param R 传入数组的右边界
     */
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            // 判断左右数组两个指针指向的元素谁大，一样的就放左不放右（小和问题是放右不放左）
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 下面的两个while只会执行其中一个。
        // 意思是将指针还没为空的一个数组（左右数组）拷贝到help辅助数组中
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        // arr拿到help数组，此时arr就是排序好的数组
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

}

