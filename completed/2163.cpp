class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        int n = nums.size() / 3;

        long long total = 0;
        for (int num : nums) {
            total += num;
        }

        // minimize sum_first
        long long sum_first = 0;
        priority_queue<int> maxHeap;
        for (int i = 0; i < n; i++) {
            sum_first += nums[i];
            maxHeap.push(nums[i]);
        }

        // maximize sum_second
        vector<long long> sum_seconds(n + 1);
        priority_queue<int, vector<int>, greater<>> minHeap;
        for (int i = 2 * n; i < nums.size(); i++) {
            sum_seconds[n] += nums[i];
            minHeap.push(nums[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            sum_seconds[i] = sum_seconds[i + 1] + nums[n + i];
            minHeap.push(nums[n + i]);
            sum_seconds[i] -= minHeap.top();
            minHeap.pop();
        }

        long long difference = sum_first - sum_seconds.back();
        for (int i = 0; i <= n; i++) {
            difference = min(sum_first - sum_seconds[i], difference);

            sum_first += nums[n + i];
            maxHeap.push(nums[n + i]);
            sum_first -= maxHeap.top();
            maxHeap.pop();
        }
        return difference;
    }
};
