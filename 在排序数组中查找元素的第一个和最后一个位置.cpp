#define _CRT_SECURE_NO_WARNINGS 1
#include<vector>
#include<iostream>
using namespace std;
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        // ��Ϊ���Ҳ��� ��������
        int leftBorder = getleftBorder(nums, target);
        int rightBorder = getrightBorder(nums, target);
        // ���һ �� target��nums������������� ����{ -1 ��-1 }
        if (leftBorder == -2 || rightBorder == -2) return { -1,-1 };
        // ����� : target ��nums�����У����������һ������target����
        if (rightBorder - leftBorder > 1) return { leftBorder + 1,rightBorder - 1 };
        // ����� �� target��nums�����У���������û��target����
        return { -1,-1 };
    }
private:
    int getleftBorder(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        int leftBorder = -2;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                right = middle - 1;
                leftBorder = right;
            }
            else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }
    int getrightBorder(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        int rightBorder = -2;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
};

int main() {
    Solution solution;
    vector<int> nums = { 5, 7, 7, 8, 8, 10 };
    int target = 8;
    cout << solution.searchRange(nums, target) << endl;
}