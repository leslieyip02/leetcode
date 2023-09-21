#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
private:
    const int INF = 1e4;

public:
    int videoStitching(vector<vector<int>>& clips, int time) {
        sort(clips.begin(), clips.end(), [](const auto &c1, const auto &c2) {
            return c1.front() < c2.front();
        });

        vector<int> c(time + 1, INF);
        c[0] = 0;
        for (auto clip : clips) {
            int start = clip.front();
            int end = clip.back();
            for (int i = start + 1; i <= end && i <= time; i++) {
                c[i] = min(c[start] + 1, c[i]);
            }
        }
        return c.back() != INF ? c.back() : -1;
    }
};

int main() {
    vector<vector<int>> clips = { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } };
    int time = 10;

    Solution solution;
    cout << solution.videoStitching(clips, time) << endl;

    clips = { { 0, 4 }, { 2, 8 } };
    time = 5;
    cout << solution.videoStitching(clips, time) << endl;
    return 0;
}
