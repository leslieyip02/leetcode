#include <algorithm>
#include <cstdlib>
#include <vector>
using namespace std;

class Solution {
private:
    struct job {
        int difficulty;
        int profit;
    };

public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        int n = difficulty.size();
        vector<job> jobs(n);
        for (int i = 0; i < n; i++) {
            jobs[i].difficulty = difficulty[i];
            jobs[i].profit = profit[i];
        }
        sort(jobs.begin(), jobs.end(), [](const job& a, const job& b) { return a.difficulty < b.difficulty; }); 
        for (int i = 1; i < n; i++) {
            if (jobs[i].profit < jobs[i - 1].profit) {
                jobs[i].profit = jobs[i - 1].profit;
            }
        }

        int t = 0;
        for (int w : worker) {
            int l = 0;
            int r = n - 1;
            int m = (l + r) / 2;
            int p = 0;
            while (l <= r) {
                if (w >= jobs[m].difficulty) {
                    p = max(jobs[m].profit, p);
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                m = (l + r) / 2;
            }
            t += p;
        }
        return t;
    }
};
