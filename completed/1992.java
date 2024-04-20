import java.util.*;

class Solution {
    public int[][] findFarmland(int[][] land) {
        List<Integer[]> groups = new ArrayList<>();

        int m = land.length;
        int n = land[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] != 1) {
                    continue;
                }

                int h = 1;
                while (i + h < m && land[i + h][j] == 1) {
                    h++;
                }
                int w = 1;
                while (j + w < n && land[i][j + w] == 1) {
                    w++;
                }
                groups.add(new Integer[]{ i, j, i + h - 1, j + w - 1 });
                for (int p = 0; p < h; p++) {
                    for (int q = 0; q < w; q++) {
                        land[i + p][j + q] = 0;
                    }
                }
            }
        }

        int[][] result = new int[groups.size()][4];
        for (int i = 0; i < groups.size(); i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = groups.get(i)[j];
            }
        }
        return result;
    }
}
