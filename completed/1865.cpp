class FindSumPairs {
private:
    vector<int> nums1;
    vector<int> nums2;
    unordered_map<int, int> available;

public:
    FindSumPairs(vector<int>& nums1, vector<int>& nums2) {
        this->nums1 = nums1;
        this->nums2 = nums2;
        for (int i = 0; i < nums2.size(); i++) {
            available[nums2[i]]++;
        }
    }
    
    void add(int index, int val) {
        available[nums2[index]]--;
        nums2[index] += val;
        available[nums2[index]]++;
    }
    
    int count(int tot) {
        int pairs = 0;
        for (int num : nums1) {
            auto itr = available.find(tot - num);
            if (itr != available.end()) {
                pairs += itr->second;
            }
        }
        return pairs;
    }
};

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs* obj = new FindSumPairs(nums1, nums2);
 * obj->add(index,val);
 * int param_2 = obj->count(tot);
 */
