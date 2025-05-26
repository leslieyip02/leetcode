class Solution {
private:
    bool inside(vector<int> &point, vector<int> &query) {
        int dx = point[0] - query[0];
        int dy = point[1] - query[1];
        int r = query[2];
        return (dx * dx + dy * dy) <= (r * r);
    }

public:
    vector<int> countPoints(vector<vector<int>>& points, vector<vector<int>>& queries) {
        vector<int> answer;
        for (vector<int> &query : queries) {
            int count = 0;
            for (vector<int> &point : points) {
                if (inside(point, query)) {
                    count++;
                }
            }
            answer.push_back(count);
        }
        return answer;
    }
};
