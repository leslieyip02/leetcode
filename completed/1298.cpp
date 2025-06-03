class Solution {
public:
    int maxCandies(
        vector<int>& status,
        vector<int>& candies,
        vector<vector<int>>& keys,
        vector<vector<int>>& containedBoxes,
        vector<int>& initialBoxes
    ) {
        queue<int> boxes;
        for (int box : initialBoxes) {
            boxes.push(box);
        }

        int total = 0;
        vector<bool> visited(status.size(), false);
        unordered_set<int> unopened;
        while (!boxes.empty()) {
            int current = boxes.front();
            boxes.pop();
            if (visited[current]) {
                continue;
            }

            if (status[current] == 0) {
                unopened.insert(current);
                continue;
            }

            total += candies[current];
            visited[current] = true;

            for (int key : keys[current]) {
                status[key] = 1;
                auto itr = unopened.find(key);
                if (itr != unopened.end()) {
                    boxes.push(key);
                    unopened.erase(itr);
                }
            }
            for (int box : containedBoxes[current]) {
                if (!visited[box]) {
                    boxes.push(box);
                }
            }
        }
        return total;
    }
};
