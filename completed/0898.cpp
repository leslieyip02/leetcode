class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        unordered_set<int> unique;
        unordered_set<int> seen;
        for (int num : arr) {
            unordered_set<int> next;
            for (int previous : seen) {
                next.insert(num | previous);
            }
            next.insert(num);

            seen = next;
            unique.insert(seen.begin(), seen.end());
        }
        return unique.size();
    }
};
