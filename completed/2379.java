class Solution {
    public int minimumRecolors(String blocks, int k) {
        int b = 0;
        int w = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') {
                b++;
            } else {
                w++;
            }
        }

        int ops = w;
        for (int i = 0; i < blocks.length() - k; i++) {
            if (blocks.charAt(i) == 'B') {
                b--;
            } else {
                w--;
            }

            if (blocks.charAt(i + k) == 'B') {
                b++;
            } else {
                w++;
            }
            ops = Math.min(ops, w);
        }
        return ops;
    }
}
