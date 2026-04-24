class Solution {
private:
    int helper(int num) {
        unordered_set<int> divisors;
        for (int i = 1; i <= sqrt(num); i++) {
            if (num % i == 0) {
                divisors.insert(i);
                divisors.insert(num / i);
            }
        }

        if (divisors.size() != 4) {
            return 0;
        }

        int sum = 0;
        for (int divisor : divisors) {
            sum += divisor;
        }
        return sum;
    }

public:
    int sumFourDivisors(vector<int>& nums) {
        int sum = 0;
        for (int num : nums) {
            sum += helper(num);
        }
        return sum;
    }
};
