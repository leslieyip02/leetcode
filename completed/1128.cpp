class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        int counts[9][9];
        for (vector<int> domino : dominoes) {
            int a = domino[0] - 1;
            int b = domino[1] - 1;
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            counts[a][b]++;
        }
        int pairs = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (counts[i][j] <= 1) {
                    continue;
                }
                pairs += (counts[i][j] * (counts[i][j] - 1)) / 2;
            }
        }
        return pairs;
    }
};
