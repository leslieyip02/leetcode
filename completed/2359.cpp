class Solution {
private:
    vector<int> distances(vector<int> &edges, int start) {
        vector<int> distances(edges.size(), -1);
        int distance = 0;
        int current = start;
        while (distances[current] == -1) {
            distances[current] = distance;
            distance++;

            if (edges[current] == -1) {
                break;
            }
            current = edges[current];
        }
        return distances;
    }

public:
    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        vector<int> distances1 = distances(edges, node1);
        vector<int> distances2 = distances(edges, node2);

        int closest = edges.size() + 1;
        int index = -1;
        for (int i = 0; i < edges.size(); i++) {
            if (distances1[i] == -1 || distances2[i] == -1) {
                continue;
            }

            int distance = max(distances1[i], distances2[i]);
            if (max(distances1[i], distances2[i]) < closest) {
                closest = distance;
                index = i;
            }
        }
        return index;
    }
};
