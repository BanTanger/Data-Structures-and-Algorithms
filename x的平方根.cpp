#define _CRT_SECURE_NO_WARNINGS 1class Solution {
public:
    int mySqrt(int x) {
        // ���ֲ���
        // ��left = 0��right = x�����ƣ���ͨ���м�ֵmiddle �ĳ˻����ж��Ƿ�middleΪ����ƽ����
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