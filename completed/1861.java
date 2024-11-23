import java.util.*;

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        char[][] rotated = new char[n][m];
        for (char[] row : rotated) {
            Arrays.fill(row, '.');
        }
        for (int i = 0; i < m; i++) {
            int row = n - 1;
            int column = m - i - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '.') {
                    continue;
                }

                if (box[i][j] == '#') {
                    rotated[row][column] = '#';
                } else if (box[i][j] == '*') {
                    rotated[j][column] = '*';
                    row = j;
                }
                row--;
            }
        }
        return rotated;
    }
}
