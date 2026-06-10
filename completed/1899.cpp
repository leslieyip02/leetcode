class Solution {
public:
    bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
        int mask = 0;
        for (auto triplet : triplets) {
            int matches = 0;
            for (int i = 0; i < 3; i++) {
                if (triplet[i] > target[i]) {
                    matches = 0;
                    break;
                } else if (triplet[i] == target[i]) {
                    matches |= 1 << i;
                }
            }
            mask |= matches;
        }
        return mask == 0b111;
    }
};
