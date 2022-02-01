#define _CRT_SECURE_NO_WARNINGS 1class Solution {
public:
    int mySqrt(int x) {
        // 二分查找
        // 设left = 0，right = x（近似），通过中间值middle 的乘积来判断是否middle为算数平方根
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if ((long long)middle * middle <= x) {
                ans = middle;
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return ans;
    }
};