class Solution {
private:
    int find(int current, vector<int> &parents) {
        if (parents[current] == current) {
            return current;
        }

        int parent = find(parents[current], parents);
        parents[current] = parent;
        return parent;
    }

    void unite(int current, int other, vector<int> &parents) {
        if (current != find(current, parents)) {
            current = find(current, parents);
        }
        if (other != find(other, parents)) {
            other = find(other, parents);
        }
        parents[current] = parents[other] = min(current, other);
    }

public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        vector<int> parents(26);
        for (int i = 0; i < parents.size(); i++) {
            parents[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            unite((int) s1[i] - 'a', (int) s2[i] - 'a', parents);
        }

        string result = "";
        for (char c : baseStr) {
            int index = (int) c - 'a';
            result += (char) find(index, parents) + 'a';
        }
        return result;
    }
};
