class Solution {
public:
    int numberOfArrays(vector<int>& differences, int lower, int upper) {
        int n = differences.size() + 1;
        long minimum = 0;
        long maximum = 0;
        vector<long> prefixSums(n);
        for (int i = 0; i < n - 1; i++) {
            prefixSums[i + 1] = prefixSums[i] + differences[i];
            minimum = min(prefixSums[i + 1], minimum);
            maximum = max(prefixSums[i + 1], maximum);
        }

        if (minimum < 0) {
            lower += -minimum;
        }
        if (maximum > 0) {
            upper -= maximum;
        }
        long difference = (long) upper - lower + 1;
        if (difference > INT_MAX) {
            return 0;
        }
        return max((int) difference, 0);
    }
};
