package com.bantanger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bantanger 半糖
 * @version 1.0
 */
public class BackTrackingPrintFunction {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    // 全局变量，记录递归函数的递归层数
    int count = 0;


    // 输入 n，打印 n 个 tab 缩进
    void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("    ");
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getCombination(candidates, target, 0);
        return res;
    }


    private void getCombination(int[] candidates, int target, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            System.out.println("进入收集，第" + count + "层 ,收集到结果=" + path.toString());
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            sum += candidates[i];
            path.add(candidates[i]);

            printIndent(count++);
            System.out.println("i=" + i + "第" + count + "层 ,回溯前=" + path.toString() + "sum=" + sum);

            getCombination(candidates, target, i);

            sum -= candidates[i];
            path.removeLast();
            printIndent(--count);
            System.out.println("i=" + i + "第" + count + "层 ,回溯后=" + path.toString());
        }
    }
}
