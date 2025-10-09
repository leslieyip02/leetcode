class Solution {

    private static final char UNUSED = '!';

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[][] buffer = new char[numRows][s.length()];
        for (int i = 0; i < numRows; i++) {
            Arrays.fill(buffer[i], UNUSED);
        }

        int r = 0;
        int c = 0;
        int dr = 0;
        int dc = 0;
        for (int i = 0; i < s.length(); i++) {
            buffer[r][c] = s.charAt(i);

            if (r == 0) {
                dr = 1;
                dc = 0;
            } else if (r == numRows - 1) {
                dr = -1;
                dc = 1;
            }

            r += dr;
            c += dc;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < buffer[i].length; j++) {
                if (buffer[i][j] == UNUSED) {
                    continue;
                }
                sb.append(buffer[i][j]);
            }
        }
        return sb.toString();
    }
}
