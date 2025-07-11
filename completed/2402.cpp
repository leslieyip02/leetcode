#define ull unsigned long long

class Solution {
private:
    struct Room {
        int index;
        ull free;

        Room(int index, ull free) : index(index), free(free) {}
    };

public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        auto lowest = [](const Room& lhs, const Room& rhs) {
            return lhs.index > rhs.index;
        };
        priority_queue<Room, vector<Room>, decltype(lowest)> available(lowest);
        for (int i = 0; i < n; i++) {
            Room room(i, 0);
            available.push(room);
        }

        auto earliest = [](const Room& lhs, const Room& rhs) {
            return lhs.free == rhs.free ? lhs.index > rhs.index : lhs.free > rhs.free;
        };
        priority_queue<Room, vector<Room>, decltype(earliest)> ongoing(earliest);

        vector<int> counts(n, 0);
        sort(meetings.begin(), meetings.end());
        for (auto meeting : meetings) {
            while (!ongoing.empty() && ongoing.top().free <= meeting[0]) {
                available.push(ongoing.top());
                ongoing.pop();
            }

            Room next(-1, -1);
            if (available.empty()) {
                next.index = ongoing.top().index;
                ull start = max(ongoing.top().free, (ull) meeting[0]);
                ull duration = meeting[1] - meeting[0];
                next.free = start + duration;
                ongoing.pop();
            } else {
                next.index = available.top().index;
                ull start = max(available.top().free, (ull) meeting[0]);
                ull duration = meeting[1] - meeting[0];
                next.free = start + duration;
                available.pop();
            }
            counts[next.index]++;
            ongoing.push(next);
        }

        int index = 0;
        for (int i = 1; i < n; i++) {
            if (counts[i] > counts[index]) {
                index = i;
            }
        }
        return index;
    }
};
