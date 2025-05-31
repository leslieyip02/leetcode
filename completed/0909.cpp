class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        int n = board.size();
        vector<int> flattened(n * n);
        for (int i = 0; i < n; i++) {
            int row = n - 1 - i;
            for (int j = 0; j < n; j++) {
                int col = i % 2 == 0 ? j : n - 1 - j;
                flattened[i * n + j] = board[row][col];
            }
        }

        vector<int> moves(n * n, (int) 1e9);
        moves[0] = 0;

        queue<int> cells;
        cells.push(0);
        while (!cells.empty()) {
            int current = cells.front();
            cells.pop();
            for (int i = 1; i <= 6; i++) {
                int target = current + i;
                if (target >= flattened.size()) {
                    break;
                }

                int next = flattened[target] == -1 ? target : flattened[target] - 1;
                if (moves[current] + 1 < moves[next]) {
                    moves[next] = moves[current] + 1;
                    cells.push(next);
                }
            }
        }
        return moves[n * n - 1] == (int) 1e9 ? -1 : moves[n * n - 1];
    }
};
