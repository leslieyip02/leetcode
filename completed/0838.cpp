class Solution {
public:
    string pushDominoes(string dominoes) {
        queue<int> pushed;
        for (int i = 0; i < dominoes.size(); i++) {
            if (dominoes[i] == '.') {
                continue;
            }
            pushed.push(i);
        }

        string previous = dominoes;
        while (!pushed.empty()) {
            string current = previous;
            int size = pushed.size();
            for (int i = 0; i < size; i++) {
                int index = pushed.front();
                pushed.pop();

                int direction = previous[index] == 'L' ? -1 : 1;
                int next = index + direction;
                if (next < 0 || next >= dominoes.size()) {
                    continue;
                }
                if (previous[next] != '.') {
                    continue;
                }

                int over = next + direction;
                if (over < 0 || over >= dominoes.size() || previous[over] == '.' || previous[over] == previous[index]) {
                    current[next] = previous[index];
                    pushed.push(next);
                    continue;
                }
            }
            previous = current;
        }
        return previous;
    }
};
