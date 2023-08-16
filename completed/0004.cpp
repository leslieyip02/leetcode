#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        int target = (m + n) / 2;
        if (m == 0 || n == 0) {
            vector<int> nums = n == 0 ? nums1 : nums2;
            if (nums.size() % 2 == 0) {
                return (nums[target] + nums[target - 1]) / 2.0;
            } else {
                return nums[target];
            }
        }

        int p1 = 0;
        int q1 = m;
        int p2 = 0;
        int q2 = n;
        while (q1 > p1 && q2 > p2 && (q1 - p1) + (q2 - p2) > target + 1) {
            int i1 = (p1 + q1) / 2;
            int i2 = (p2 + q2) / 2;
            if (i1 + i2 < target) {                
                if (nums1[i1] < nums2[i2]) {
                    target -= (i1 - p1);
                    p1 = i1;
                    if (p1 == i1) {
                        break;
                    }
                } else {
                    target -= (i2 - p2);
                    p2 = i2;
                    if (p2 == i2) {
                        break;
                    }
                }
            } else {
                if (nums1[i1] > nums2[i2]) {
                    q1 = i1;
                } else {
                    q2 = i2;
                }
            }
        }

        vector<int> merged;
        while (p1 < q1 || p2 < q2) {
            int v1 = p1 < q1 ? nums1[p1] : (int) 1e7;
            int v2 = p2 < q2 ? nums2[p2] : (int) 1e7;
            if (v1 < v2) {
                merged.push_back(v1);
                p1++;
            } else {
                merged.push_back(v2);
                p2++;
            }
        }

        if ((m + n) % 2 == 0) {
            return (merged[target] + merged[target - 1]) / 2.0;
        } else {
            return merged[target];
        }
    }
};

int main() {
    Solution solution;
    vector<int> nums1;
    vector<int> nums2;
    nums1 = { 0, 0, 0, 0, 0 };
    nums2 = { -1, 0, 0, 0, 0, 0, 1 };
    cout << solution.findMedianSortedArrays(nums1, nums2) << endl;
    nums1 = { 1 };
    nums2 = { 2, 3, 4, 5 };
    cout << solution.findMedianSortedArrays(nums1, nums2) << endl;
    nums1 = { 1, 2, 2 };
    nums2 = { 1, 2, 3 };
    cout << solution.findMedianSortedArrays(nums1, nums2) << endl;
    nums1 = { 1, 3 };
    nums2 = { 2 };
    cout << solution.findMedianSortedArrays(nums1, nums2) << endl;
    nums1 = { 2, 2, 4, 4 };
    nums2 = { 2, 2, 4, 4 };
    cout << solution.findMedianSortedArrays(nums1, nums2) << endl;
    nums1 = { 1 };
    nums2 = { 2, 3, 4 };
    cout << solution.findMedianSortedArrays(nums1, nums2) << endl;

    return 0;
}
