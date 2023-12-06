class Solution {
    public int totalMoney(int n) {
        int base = 0;
        for (int i = 1; i <= 7; i++) {
            base += i;
        }

        int total = 0;
        int weeks = 1;
        while (weeks * 7 <= n) {
            total += base;
            base += 7;
            weeks++;
        }

        int extra = n % 7;
        for (int i = 0; i < extra; i++) {
            total += (weeks + i);
        }
        return total;
    }

    public static void main(String[] args) {
        // int n = 4;
        int n = 10;

        Solution solution = new Solution();
        System.out.println(solution.totalMoney(n));
    }
}
