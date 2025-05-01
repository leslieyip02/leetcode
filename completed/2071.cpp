class Solution {
private:
    bool isCompletable(int n, vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        multiset<int> available;
        for (int i = workers.size() - n; i < workers.size(); i++) {
            available.insert(workers[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            auto itr = prev(available.end());
            if (*itr >= tasks[i]) {
                available.erase(itr);
                continue;
            }

            if (pills == 0) {
                return false;
            }
            itr = available.lower_bound(tasks[i] - strength);
            if (itr == available.end()) {
                return false;
            }
            available.erase(itr);
            pills--;
        }
        return true;
    }

public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        sort(tasks.begin(), tasks.end());
        sort(workers.begin(), workers.end());

        int left = 0;
        int right = min(tasks.size(), workers.size());
        while (right - left > 1) {
            int middle = (left + right) / 2;
            if (isCompletable(middle, tasks, workers, pills, strength)) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return isCompletable(right, tasks, workers, pills, strength) ? right : left;
    }
};
