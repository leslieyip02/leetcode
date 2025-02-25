class Solution {
private:
    int M = 1e9 + 7;

public:
    int numOfSubarrays(vector<int>& arr) {
        int odd = 0;
        int even = 1;
        int current = 0;
        int count = 0;
        for (int num : arr) {
            current += num;
            if (current % 2 == 1) {
                odd++;
                count = (count + even) % M;
            } else {
                even++;
                count = (count + odd) % M;
            }
        }
        return count;
    }
};
