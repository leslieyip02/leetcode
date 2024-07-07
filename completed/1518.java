class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        int full = numBottles;
        int empty = 0;
        while ((full + empty) >= numExchange) {
            total += full;
            empty += full;
            full = empty / numExchange;
            empty = empty % numExchange;
        }
        total += full;
        return total;
    }
}
