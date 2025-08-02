class Solution {
public:
    long long minCost(vector<int>& basket1, vector<int>& basket2) {
        unordered_map<int, int> counts1;
        unordered_map<int, int> counts2;
        unordered_map<int, int> combined;
        for (int fruit : basket1) {
            counts1[fruit]++;
            combined[fruit]++;
        }
        for (int fruit : basket2) {
            counts2[fruit]++;
            combined[fruit]++;
        }

        int smallest = 1e9;
        deque<int> swap1;
        deque<int> swap2;
        for (auto &[fruit, count] : combined) {
            if (count % 2 != 0) {
                return -1;
            }

            smallest = min(fruit, smallest);

            int expected = count / 2;
            for (int i = counts1[fruit]; i < expected; i++) {
                swap2.push_back(fruit);
            }
            for (int i = counts2[fruit]; i < expected; i++) {
                swap1.push_back(fruit);
            }
        }

        sort(swap1.begin(), swap1.end());
        sort(swap2.begin(), swap2.end());

        int smallestSwap = smallest * 2;
        long long cost = 0;
        while (!swap1.empty()) {
            int front1 = swap1.front();
            int front2 = swap2.front();
            if (smallestSwap < front1 && smallestSwap < front2) {
                swap1.pop_front();
                swap2.pop_front();
                cost += smallestSwap;
            } else if (front1 < front2) {
                swap1.pop_front();
                swap2.pop_back();
                cost += front1;
            } else {
                swap2.pop_front();
                swap1.pop_back();
                cost += front2;
            }
        }
        return cost;
    }
};
