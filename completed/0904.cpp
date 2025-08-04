class Solution {
private:
    const int NOT_FOUND = -1;

public:
    int totalFruit(vector<int>& fruits) {
        int total = 0;
        int left = 0;
        while (left < fruits.size()) {
            int fruit = fruits[left];
            int other = NOT_FOUND;
            int next = NOT_FOUND;
            int right = left;
            while (right < fruits.size()) {
                if (fruits[right] == fruit || fruits[right] == other) {
                    right++;
                    continue;
                }

                if (other == NOT_FOUND) {
                    other = fruits[right];
                    next = right;
                    right++;
                    continue;
                }

                break;
            }
            total = max(right - left, total);
            left = next == NOT_FOUND ? right : next;
        }
        return total;
    }
};

