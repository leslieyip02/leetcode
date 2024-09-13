class Solution {
    private static final int INF = (int) 1e9;

    public int coinChange(int[] coins, int amount) {
        int[] counts = new int[amount + 1];
        Arrays.fill(counts, INF);
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                coins = Arrays.copyOfRange(coins, 0, i);
                break;
            }
            counts[coins[i]] = 1;
        }
        counts[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            if (counts[i] != INF) {
                for (int coin : coins) {
                    if (i + coin > amount) {
                        break;
                    }
                    counts[i + coin] = Math.min(counts[i] + 1, counts[i + coin]);
                }
            }
        }
        return counts[amount] == INF ? -1 : counts[amount];
    }
}
