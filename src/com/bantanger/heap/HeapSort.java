package com.bantanger.heap;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {

    }

    /**
     * 《 向上 》堆化部分，新插入的值与父节点比大小
     * 如果大于父节点就交换双方，直到不大于为止
     * @param arr 数组
     * @param index 新插入进来的下标索引
     */
    public static void heapInsert(int[] arr , int index){
        while(arr[index] > arr[(index - 1) / 2]) {
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 《 向下 》堆化部分，根节点与孩子比大小
     * 如果大于父节点就交换双方，直到不大于为止
     * @param arr 数组
     * @param index 从根节点下标开始
     * @param heapSize 堆大小，用于管理左右孩是否越界
     */
    public static void heapIfy(int[] arr,int index ,int heapSize){
        int left = index * 2 + 1; // 左孩下标
        while(left < heapSize){
            // 两个孩子，谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1]
                    ? left + 1 : left; // 先判断是否有右孩，如果有右孩判断是否右孩值大于左孩
            // 父与较大孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break; // 父节点最大，直接退出循环
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int L, int R) {
        arr[L] = arr[L] ^ arr[R];
        arr[R] = arr[L] ^ arr[R];
        arr[L] = arr[L] ^ arr[R];
    }
}
