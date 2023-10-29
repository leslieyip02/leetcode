class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int t = minutesToTest / minutesToDie + 1;
        int x = 0;
        while (Math.pow(t, x) < buckets) {
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 60;

        Solution solution = new Solution();
        System.out.println(solution.poorPigs(buckets, minutesToDie, minutesToTest));
    }
}
