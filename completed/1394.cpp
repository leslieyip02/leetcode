class Solution {
public:
    int findLucky(vector<int>& arr) {
        unordered_map<int, int> counts;      
        for (int num : arr) {
            counts[num]++;
        }

        int largest = -1;
        for (auto &[key, val] : counts) {
            if (key != val) {
                continue;
            }
            largest = max(key, largest);
        }
        return largest;
    }
};
