class Solution {
public:
    int countCompleteSubarrays(vector<int>& nums) {
        unordered_set<int> distinctElements;
        for (int num : nums) {
            distinctElements.insert(num);
        }

        int left = 0;
        int right = 0;
        int count = 0;
        unordered_map<int, int> currentElements;
        while (left < nums.size()) {
            while (right < nums.size() && currentElements.size() < distinctElements.size()) {
                currentElements[nums[right]]++;
                right++;
            }

            if (currentElements.size() < distinctElements.size()) {
                break;
            }

            count += nums.size() - right + 1;
            currentElements[nums[left]]--;
            if (currentElements[nums[left]] == 0) {
                currentElements.erase(nums[left]);
            }
            left++;
        }
        return count;
    }
};
