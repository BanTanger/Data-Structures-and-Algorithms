package com.bantanger.graph;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/4/28 9:48
 */
public class Graph {
    private static int[] Vertices;
    private static int[][] edge; // 矩阵
    private static int numOfEdges; // 边

    public static void Initiate(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 初始化，将图的每一个节点与自身节点之间的度设置为0
                if(i == j) edge[i][j] = 0;
                else edge[i][j] = -1;
            }
        }
    }

    /**
     * 在图中寻找序号为v的顶点的第一个邻接顶点
     * 如果这个顶点存在，就返回邻接顶点的序号，否则返回-1
     * @param v
     * @return
     */
    public static int GetFirstVex(int v) {
        if(v < 0 || v >= Vertices.length){
            throw new RuntimeException("参数传入越界");
        }
        for (int col = 0; col < Vertices.length; col++) {
            if(edge[v][col] != -1) return col;
        }
        return -1;
    }

    public static void InsertVertex(int[] vertex){
        // 增加顶点
    }

    public static void InsertEdge(int v1,int v2,int weight){
        if(v1 < 0 || v2 < 0 || v1 < Vertices.length || v2 < Vertices.length){
            System.out.println("参数设置错误");
            return;
        }
        edge[v1][v2] = weight;
        numOfEdges++;
    }

    public static void DeleteEdge(int v1,int v2){
        if(v1 < 0 || v2 < 0 || v1 < Vertices.length || v2 < Vertices.length || v1 == v2){
            System.out.println("参数设置错误");
            return;
        }
        if(edge[v1][v2] == -1) {
            System.out.println("要删除的边不存在");
            return;
        }
        edge[v1][v2] = -1;
        numOfEdges--;
    }
}

