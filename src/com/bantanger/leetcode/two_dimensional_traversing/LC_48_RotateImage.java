package com.bantanger.leetcode.two_dimensional_traversing;

import org.junit.jupiter.api.Test;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/22 13:03
 */
public class LC_48_RotateImage {
    class Solution {
        public void printMatrix(int[][] matrix){
            for(int[] row : matrix){
                for(int col : row){
                    System.out.print(col + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 对称轴翻转
            for(int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    /*System.out.println("交换前");
                    printMatrix(matrix);*/
                    System.out.println("i : " + i + " --- " + "j : " + j);
                    // swap(matrix[i][j],matrix[j][i]);
                    // 注意这里不能通过一个swap（int a,int b）来交换元素，
                    // 因为java是浅拷贝传参，交换只在函数内部而不会影响到本函数，
                    // 一定要传入数组去改变这个数组，
                    // 但这样逆序函数的交换函数又要重载，所以直接写交换算了
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;

                    System.out.println("swap(matrix[i][j],matrix[j][i])");
                    System.out.printf("     swap(matrix[%d][%d],matrix[%d][%d])\n",i,j,j,i);

                    printMatrix(matrix);
                }

            }
            // 水平翻转
            for(int[] row : matrix){
                reverse(row);
            }
        }
        private void reverse(int[] row){
            int left = 0, right = row.length - 1;
            while(left < right){
                // swap(row[left],row[right]);
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }
    @Test
    public void test(){
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        new Solution().rotate(arr);
    }
}
