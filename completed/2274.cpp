class Solution {
public:
    int maxConsecutive(int bottom, int top, vector<int>& special) {
        sort(special.begin(), special.end());
        int best = *special.begin() - bottom;
        int current = bottom;
        for (int floor : special) {
            best = max(floor - 1 - current, best);
            current = floor;
        }
        best = max(top - current, best);
        return best;
    }
};
