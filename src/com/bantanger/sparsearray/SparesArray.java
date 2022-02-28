package com.bantanger.sparsearray;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class SparesArray {
    public static void main(String[] args) {
        // 先创建原始二维数组
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 1;
        chessArr1[4][5] = 2;
        chessArr1[6][5] = 1;
        /*System.out.println("原始二维数组");
        for (int[] row : chessArr1) {
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }*/

        // 原始二维数组转换成稀疏数组
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        // 创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 再遍历一次原始二维数组，找出所有非零数据
        int count = 0; // 创建一个计数变量
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // print稀疏数组
        System.out.println("稀疏数组");
        for (int[] row : sparseArr){
            for (int data : row){
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        // 稀疏数组转原始二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 稀疏数组第二行数据赋给原始的二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArr2){
            for (int data : row){
                System.out.print(data + "\t");
            }
            System.out.println();
        }
    }
}
