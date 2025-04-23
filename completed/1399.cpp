class Solution {
private:
    int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

public:
    int countLargestGroup(int n) {
        int largest = 0;
        int count = 0;
        unordered_map<int, int> counts;
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            counts[sum]++;
            if (counts[sum] > largest) {
                largest = counts[sum];
                count = 1;
            } else if (counts[sum] == largest) {
                count++;
            }
        }
        return count;
    }
};
