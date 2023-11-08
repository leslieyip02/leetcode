class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dx = Math.abs(fx - sx);
        int dy = Math.abs(fy - sy);
        return dx == 0 && dy == 0
            ? t != 1
            : dx <= t && dy <= t;
    }

    public static void main(String[] args) {
        // int sx = 2;
        // int sy = 4;
        // int fx = 7;
        // int fy = 7;
        // int t = 6;
        int sx = 1;
        int sy = 1;
        int fx = 1;
        int fy = 4;
        int t = 3;

        Solution solution = new Solution();
        System.out.println(solution.isReachableAtTime(sx, sy, fx, fy, t));
    }
}
