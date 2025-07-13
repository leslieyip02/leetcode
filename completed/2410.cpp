class Solution {
public:
    int matchPlayersAndTrainers(vector<int>& players, vector<int>& trainers) {
        sort(players.begin(), players.end());
        sort(trainers.begin(), trainers.end());

        int n = players.size();
        int m = trainers.size();
        int count = 0;
        for (int i = 0, j = 0; i < n; i++, j++) {
            while (j < m && trainers[j] < players[i]) {
                j++;
            }
            if (j < m) {
                count++;
            }
        }
        return count;
    }
};
