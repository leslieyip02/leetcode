class Solution {
    public int smooth(int[][] img, int i, int j) {
        int sum = 0;
        int ok = 0;
        for (int k = 0; k < 9; k++) {
            int oi = i + ((k % 3) - 1);
            int oj = j + ((k / 3) - 1);
            if (oi >= 0 && oi < img.length &&
                oj >= 0 && oj < img[0].length) {
                sum += img[oi][oj];
                ok++;
            }
        }
        return sum / ok;
    }

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] smoothed = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                smoothed[i][j] = this.smooth(img, i, j);
            }
        }
        return smoothed;
    }
}
