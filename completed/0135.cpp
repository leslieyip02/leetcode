class Solution {
public:
    int candy(vector<int>& ratings) {
        vector<int> assignments(ratings.size(), 1);
        for (int i = 1; i < ratings.size(); i++) {
            if (ratings[i] > ratings[i - 1]) {
                assignments[i] = assignments[i - 1] + 1;
            }
        }
        for (int i = ratings.size() - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                assignments[i] = max(assignments[i + 1] + 1, assignments[i]);
            }
        }
        return accumulate(assignments.begin(), assignments.end(), 0);
    }
};
