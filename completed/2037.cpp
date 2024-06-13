#include <cstdlib>
#include <vector>
using namespace std;

class Solution {
public:
    int minMovesToSeat(vector<int>& seats, vector<int>& students) {
        int x[100];
        for (int seat : seats) {
            x[seat - 1]++;
        }
        for (int student : students) {
            x[student - 1]--;
        }

        int moves = 0;
        int current = 0;
        for (int i = 0; i < 100; i++) {
            moves += abs(current);
            current += x[i];
        }
        return moves;
    }
};
