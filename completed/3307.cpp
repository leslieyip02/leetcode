class Solution {
public:
    char kthCharacter(long long k, vector<int>& operations) {
        k--;
        int current = 0;
        for (int operation : operations) {
            if (k & 1) {
                current = (current + operation) % 26;
            }
            k >>= 1;
        }
        return (char) current + 'a';
    }
};
