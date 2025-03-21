class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        vector<int> less;
        vector<int> more;
        int equal = 0;
        for (int num : nums) {
            if (num < pivot) {
                less.push_back(num);
            } else if (num > pivot) {
                more.push_back(num);
            } else {
                equal++;
            }
        }

        for (int i = 0; i < equal; i++) {
            less.push_back(pivot);
        }
        less.reserve(less.size() + more.size());
        less.insert(less.end(), more.begin(), more.end());
        return less;
    }
};
