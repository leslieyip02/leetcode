class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        int counts[10] = { 0 };
        for (int digit : digits) {
            counts[digit]++;
        }

        vector<int> possible;
        for (int i = 100; i < 1000; i += 2) {
            int needed[10] = { 0 };
            needed[i / 100]++;
            needed[i % 100 / 10]++;
            needed[i % 10]++;

            bool ok = true;
            for (int j = 0; j <= 9; j++) {
                if (needed[j] > 0 && needed[j] > counts[j]) {
                    ok = false;
                    continue;
                }
            }
            if (!ok) {
                continue;
            }
            possible.push_back(i);
        }
        return possible;
    }
};
