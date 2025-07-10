class Solution {
private:
    bool gapWithinCurrent(int current, int duration, multimap<int, int>& gaps) {
        auto itr = gaps.lower_bound(duration);
        while (itr != gaps.end()) {
            int index = itr->second;
            if (index != current && index != current + 1) {
                return false;
            }
            itr++;
        }
        return true;
    }

public:
    int maxFreeTime(int eventTime, vector<int>& startTime, vector<int>& endTime) {
        int n = startTime.size();

        multimap<int, int> gaps;
        for (int i = 1; i < n; i++) {
            int gap = startTime[i] - endTime[i - 1];
            gaps.insert({ gap, i });
        }
        gaps.insert({ startTime[0], 0 });
        gaps.insert({ eventTime - endTime[n - 1], n });

        int longest = 0;
        for (int i = 0; i < n; i++) {
            int previous = i > 0 ? endTime[i - 1] : 0;
            int next = i + 1 < n ? startTime[i + 1] : eventTime;
            int freeTime = next - previous;

            int duration = endTime[i] - startTime[i];
            if (gapWithinCurrent(i, duration, gaps)) {
                freeTime -= duration;
            }
            longest = max(freeTime, longest);
        }
        return longest;
    }
};
