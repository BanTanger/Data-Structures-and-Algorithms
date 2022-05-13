package com.bantanger.leetcode.difference_array;

/**
 * @author bantanger 半糖
 * @version 1.0
 * @Date 2022/5/13 8:46
 */
public class DifferenceArray {
    private int[] diff; // 差分数组
    private int[] res; // 结果数组

    /* 输入一个初始数组，区间操作将在这个数组上进行 */
    public DifferenceArray(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        // 根据初始数组构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* 给闭区间 [i, j] 增加 val（可以是负数）
    *  差分数组diff[i]位置增加val, diff[j + 1] 位置减少val
    *  注意如果 j + 1 >= diff.length 就不需要执行减少操作了，
    *  因为这代表整个数组都增加val
    * */
    public void increment(int i, int j, int val){
        diff[i] += val;
        if(j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    // 返回结果数组
    public int[] result(){
        res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++){
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
