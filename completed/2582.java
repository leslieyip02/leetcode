class Solution {
    public int passThePillow(int n, int time) {
        int cycle = (n - 1) * 2;
        time %= cycle;
        return time < n ? 1 + time : n - (time - n + 1);
    }
}
