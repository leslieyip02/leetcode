class Solution {
public:
    vector<vector<int>> mergeArrays(vector<vector<int>>& nums1, vector<vector<int>>& nums2) {
        vector<vector<int>> result;
        int i = 0;
        int j = 0;
        while (i < nums1.size() && j < nums2.size()) {
            int id1 = nums1[i][0];
            int val1 = nums1[i][1];
            int id2 = nums2[j][0];
            int val2 = nums2[j][1];
            if (id1 <= id2) {
                result.push_back({ id1, val1 });
                i++;
            } else {
                if (!result.empty() && id2 == result.back()[0]) {
                    result.back()[1] += val2;
                } else {
                    result.push_back({ id2, val2 });
                }
                j++;
            }
        }
        while (i < nums1.size()) {
            result.push_back(nums1[i]);
            i++;
        }
        while (j < nums2.size()) {
            if (!result.empty() && nums2[j][0] == result.back()[0]) {
                result.back()[1] += nums2[j][1];
            } else {
                result.push_back(nums2[j]);
            }
            j++;
        }
        return result;
    }
};
