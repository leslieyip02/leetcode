#define ll long long

class Solution {
public:
    int maxFreeTime(
        int eventTime,
        int k,
        vector<int>& startTime,
        vector<int>& endTime
    ) {
        int n = startTime.size();
        vector<ll> prefixSums(n + 1);
        for (int i = 0; i < n; i++) {
            ll duration = endTime[i] - startTime[i];
            prefixSums[i + 1] = prefixSums[i] + duration;
        }

        ll freeTime = 0;
        for (int i = 0; i <= n; i++) {
            if (i < n) {
                int currentEnd = i == 0 ? 0 : endTime[i - 1];
                int nextStart = i + k < n ? startTime[i + k] : eventTime;
                ll forwardSum = prefixSums[min(i + k, n)] - prefixSums[i];
                freeTime = max((nextStart - forwardSum) - currentEnd, freeTime);
            }

            if (i > 0) {
                int currentStart = startTime[i - 1];
                int previousEnd = i - k < 0 ? 0 : endTime[i - k];
                ll backwardSum = prefixSums[i] - prefixSums[max(i - k, 0)];
                freeTime = max(currentStart - (previousEnd + backwardSum), freeTime);
            }
        }
        return (int) freeTime;
    }
};
