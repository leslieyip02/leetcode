class Solution {
    private int countOnBits(long num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

    public int makeTheIntegerZero(int num1, int num2) {
        if (num1 <= num2) {
            return -1;
        }

        int operations = 0;
        while (true) {
            long current = num1;
            current -= (long) operations * num2;
            if (current <= 0) {
                break;
            }
            if (countOnBits(current) <= operations) {
                // for i >= 1, 2^i can be be split into 2^(i + 1) * 2
                // so if current == 1, it cannot be further reduced
                if (current != 1 || operations == 1) {
                    return operations;
                }
            }
            operations++;
        }
        return -1;
    }
}
