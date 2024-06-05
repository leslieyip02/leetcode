class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ways = 0;
        int max1 = total / cost1;
        for (int buy1 = 0; buy1 <= max1; buy1++) {
            int max2 = (total - buy1 * cost1) / cost2;
            ways += max2 + 1;
        }
        return ways;
    }
}
