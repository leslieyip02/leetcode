class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        int x = 0;
        int o = 0;
        int xxx = 0;
        int ooo = 0;
        for (string &row : board) {
            if (row == "XXX") xxx++;
            if (row == "OOO") ooo++;

            for (char c : row) {
                if (c == 'X') x++;
                if (c == 'O') o++;
            }
        }
        if (o > x) return false;
        if (x - o > 1) return false;

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == ' ') continue;
            if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') xxx++;
            if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O') ooo++;
        }

        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') xxx++;
        if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ooo++;
        if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') xxx++;
        if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') ooo++;

        if (xxx > 0 && ooo > 0) return false;
        if (xxx > 0 && x <= o) return false;
        if (ooo > 0 && o < x) return false;
        return true;
    }
};
