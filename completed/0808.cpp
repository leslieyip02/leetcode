class Solution {
private:
    unordered_map<int, unordered_map<int, double>> memo;

    double option(int a, int b, int da, int db) {
        if (a <= da) {
            return b <= db ? 0.5 : 1.0;
        }

        if (b <= db) {
            return 0.0;
        }

        return helper(a - da, b - db);
    }

    double helper(int a, int b) {
        if (memo.find(a) == memo.end() || memo[a].find(b) == memo[a].end()) {
            memo[a][b] = 0.25 * (
                option(a, b, 100, 0) +
                option(a, b, 75, 25) +
                option(a, b, 50, 50) +
                option(a, b, 25, 75)
            );
        }
        return memo[a][b];
    }

public:
    double soupServings(int n) {
        memo = unordered_map<int, unordered_map<int, double>>();
        return n >= 5000 ? 1.0 : helper(n, n);
    }
};
