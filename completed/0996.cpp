class Solution {
public:
    int numSquarefulPerms(vector<int>& nums) {
        unordered_map<int, int> counts;
        for (int num : nums) {
            counts[num]++;
        }
        vector<int> stack;
        return backtrack(stack, counts, nums.size());
    }

private:
    unordered_map<int, bool> is_square_memo;

    int backtrack(vector<int>& stack, unordered_map<int, int>& counts, int size) {
        if (stack.size() == size) {
            return is_squareful(stack) ? 1 : 0;
        }

        int total = 0;
        for (const auto &[k, v] : counts) {
            if (v == 0) {
                continue;
            }

            if (!stack.empty() && !is_square(stack.back() + k)) {
                continue;
            }

            counts[k]--;
            stack.push_back(k);
            total += backtrack(stack, counts, size);
            stack.pop_back();
            counts[k]++;
        }
        return total;
    }

    bool is_squareful(vector<int>& nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (!is_square(nums[i] + nums[i + 1])) {
                return false;
            }
        }
        return true;
    }

    bool is_square(int num) {
        if (!is_square_memo.contains(num)) {
            int x = (int) sqrt(num);
            is_square_memo[num] = x * x == num;
        }
        return is_square_memo[num];
    }
};
