#define Memo vector<unordered_map<int, int>>

class Solution {
private:
    struct Event {
        int start;
        int end;
        int value;
    };

    int trace(int current, vector<Event>& sorted, int k, Memo& memo) {
        if (k == 0 || current == sorted.size()) {
            return 0;
        }

        auto itr = memo[current].find(k);
        if (itr != memo[current].end()) {
            return itr->second;
        }

        int take = sorted[current].value + trace(next(current, sorted), sorted, k - 1, memo);
        int skip = trace(current + 1, sorted, k, memo);
        int result = max(take, skip);
        memo[current][k] = result;
        return result;
    }

    int next(int current, vector<Event>& sorted) {
        int left = current + 1;
        int right = sorted.size();
        int target = sorted[current].end + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sorted[mid].start < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

public:
    int maxValue(vector<vector<int>>& events, int k) {
        vector<Event> sorted(events.size());
        for (int i = 0; i < events.size(); i++) {
            sorted[i].start = events[i][0];
            sorted[i].end = events[i][1];
            sorted[i].value = events[i][2];
        }
        sort(sorted.begin(), sorted.end(), [](const Event& a, const Event& b) {
            return a.start == b.start ? a.end < b.end : a.start < b.start;
        });

        Memo memo(events.size());
        return trace(0, sorted, k, memo);
    }
};
