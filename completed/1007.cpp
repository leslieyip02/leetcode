class Solution {
private:
    int rotate(int num, vector<int>& tops, vector<int>& bottoms) {
        int count = 0;
        for (int i = 0; i < tops.size(); i++) {
            if (tops[i] == num) {
                continue;
            }
            if (bottoms[i] != num) {
                return tops.size();
            }
            count++;
        }
        return count;
    }

public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        int count = tops.size();
        for (int i = 1; i <= 6; i++) {
            count = min(rotate(i, tops, bottoms), count);
            count = min(rotate(i, bottoms, tops), count);
        }
        return count == tops.size() ? -1 : count;
    }
};
