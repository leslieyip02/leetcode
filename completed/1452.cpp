class Solution {
private:
    bool isSubset(int current, int other, vector<vector<bool>>& favorites) {
        for (int i = 0; i < favorites[current].size(); i++) {
            if (favorites[current][i] && !favorites[other][i]) {
                return false;
            }
        }
        return true;
    }

public:
    vector<int> peopleIndexes(vector<vector<string>>& favoriteCompanies) {
        int encoding = 0;
        unordered_map<string, int> encodings;
        unordered_map<string, vector<int>> commons;
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            for (string company : favoriteCompanies[i]) {
                if (encodings.find(company) == encodings.end()) {
                    encodings[company] = encoding;
                    encoding++;
                    commons[company] = vector<int>();
                }
                commons[company].push_back(i);
            }
        }

        vector<vector<bool>> favorites(favoriteCompanies.size(), vector<bool>(encoding, false));
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            for (string company : favoriteCompanies[i]) {
                favorites[i][encodings[company]] = true;
            }
        }

        vector<int> indices;
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            vector<bool> visited(favoriteCompanies.size(), false);
            visited[i] = true;

            bool ok = true;
            for (string company : favoriteCompanies[i]) {
                for (int other : commons[company]) {
                    if (visited[other]) {
                        continue;
                    }
                    visited[other] = true;

                    if (isSubset(i, other, favorites)) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    break;
                }
            }
            if (ok) {
                indices.push_back(i);
            }
        }
        return indices;
    }
};
