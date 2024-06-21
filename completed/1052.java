class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int current = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                current += customers[i];
            }
        }

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                current += customers[i];
            }
        }

        int max = current;
        for (int i = 0; i < n - minutes; i++) {
            if (grumpy[i] == 1) {
                current -= customers[i];
            }
            if (grumpy[i + minutes] == 1) {
                current += customers[i + minutes];
            }
            max = Math.max(current, max);
        }
        return max;
    }
}
