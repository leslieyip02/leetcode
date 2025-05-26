class Solution {
private:
    vector<int> primes;

    void generatePrimes(int maximum) {
        vector<bool> isPrime(maximum + 1, true);
        isPrime[0] = false;
        isPrime[1] = true;
        for (int i = 2; i <= sqrt(maximum); i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= maximum; j += i) {
                isPrime[j] = false;
            }
        }
        for (int i = 2; i <= maximum; i++) {
            if (!isPrime[i]) continue;
            primes.push_back(i);
        }
    }

    string getKey(int numerator, int denominator) {
        for (int prime : primes) {
            if (prime > numerator || prime > denominator) break;
            while (numerator % prime == 0 && denominator % prime == 0) {
                numerator /= prime;
                denominator /= prime;
            }
        }
        return format("{}/{}", numerator, denominator);
    }

public:
    Solution() {
        generatePrimes((int) 1e5);
    }

    long long interchangeableRectangles(vector<vector<int>>& rectangles) {
        unordered_map<string, int> counts;      
        for (vector<int> &rectangle : rectangles) {
            counts[getKey(rectangle[0], rectangle[1])]++;
        }

        long long pairs = 0;
        for (auto const &[_, count] : counts) {
            if (count < 2) continue;
            pairs += ((long long) count * (count - 1)) / 2;
        }
        return pairs;
    }
};
