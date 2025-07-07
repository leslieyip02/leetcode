class Solution {
private:
    struct Event {
        int start;
        int end;
    };

public:
    int maxEvents(vector<vector<int>>& events) {
        vector<Event> sorted(events.size());
        int maxDay = 0;
        for (int i = 0; i < events.size(); i++) {
            Event event;
            event.start = events[i][0];
            event.end = events[i][1];
            sorted[i] = event;
            maxDay = max(event.end, maxDay);
        }
        sort(sorted.begin(), sorted.end(), [](const Event& a, const Event& b) {
            return a.start == b.start ? a.end < b.end : a.start < b.start;
        });

        int index = 0;
        int count = 0;
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int day = 1; day <= maxDay; day++) {
            while (index < sorted.size() && sorted[index].start <= day) {
                pq.push(sorted[index].end);
                index++;
            }

            while (!pq.empty() && pq.top() < day) {
                pq.pop();
            }

            if (!pq.empty()) {
                pq.pop();
                count++;
            }
        }
        return count;
    }
};
