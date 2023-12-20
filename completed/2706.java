class Solution {
    public int buyChoco(int[] prices, int money) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int p : prices) {
            if (p < a) {
                b = a;
                a = p;
            } else if (p < b) {
                b = p;
            }
        }
        int c = a + b;
        return c > money ? money : money - c;
    }
}
