#define _CRT_SECURE_NO_WARNINGS 1
class Solution {
public:
    bool isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if ((long long)middle * middle < num) {
                left = middle + 1;
            }
            else if ((long long)middle * middle > num) {
                right = middle - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
};