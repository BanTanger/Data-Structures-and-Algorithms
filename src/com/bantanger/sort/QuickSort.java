package com.bantanger.sort;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {

    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R); // 从数组左右范围随机选一个数放到最后
            int[] p = partition(arr, L, R);
            quickSort(arr, 0, p[0] - 1); // < 区
            quickSort(arr, p[1] + 1, R); // > 区
        }
    }

    /**
     * 处理arr[l....r]的函数
     * 默认以arr[r]作为划分，arr[r] --> p 划分出 “ < p ” “ == p ” “ == p ” 三个部分
     *
     * @param arr 数组整体
     * @param L   当前子递归要处理的左边界
     * @param R   当前子递归要处理的右边界
     * @return 返回等于区域（左边界和右边界），作为划分左右边界的功能
     */
    public static int[] partition(int[] arr, int L, int R) {
        // less 和 more两个变量都不在数组内，而是数组的外部边界。 -1 以及 arr.length()
        int less = L - 1;  // 左边界范围  “ < 区域 ”
        int more = R; // 右边界范围 “ > 区域 ”
        while (L < more) { // L 表示当前数的范围， more为右边界值， 退出递归的条件是 L 触碰到 more
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
                // 在左边界后面的数与当前数做交换，
                // 更新左边界,并且当前数下标往后移动
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
                // 在右边界前面的数与当前数做交换，
                // 更新右边界，但不移动当前数下标（新交换的数没有检查）
            } else {
                L++; // 如果 arr[L] == arr[R] , 直接移动当前数下标。
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int L, int R) {
        arr[L] = arr[L] ^ arr[R];
        arr[R] = arr[L] ^ arr[R];
        arr[L] = arr[L] ^ arr[R];
    }
}
