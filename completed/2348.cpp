class Solution {
private:
    long long count(int start, int end) {
        long long distance = end - start;
        return distance * (distance + 1) / 2;
    }

public:
    long long zeroFilledSubarray(vector<int>& nums) {
        int left = 0;
        int right = 0;
        long long total = 0;
        while (right < nums.size()) {
            if (nums[right] == 0) {
                right++;
            } else {
                total += count(left, right);
                right++;
                left = right;
            }
        }
        total += count(left, right);
        return total;
    }
};
