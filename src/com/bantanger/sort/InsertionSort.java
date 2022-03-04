package com.bantanger.sort;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,7,3,9,7,4,0,4,6,3,1};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 插入排序，最好情况O(N),最坏情况O(N²)
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0~0有序 OK
        // 0~i有序
        for (int i = 0; i < arr.length; i++) { // 0 ~ i 做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }
    public static void swap(int[] arr,int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
