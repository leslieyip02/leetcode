class Solution {
private:
    struct Node {
        bool terminal;
        unordered_map<string, Node *> children;

        bool insert(vector<string> segments, int index) {
            if (terminal) {
                return false;
            }

            if (index == segments.size()) {
                terminal = true;
                return true;
            }

            string segment = segments[index];
            if (children.find(segment) == children.end()) {
                children[segment] = new Node();
            }
            return children[segment]->insert(segments, index + 1);
        }
    };

public:
    vector<string> removeSubfolders(vector<string>& folder) {
        sort(folder.begin(), folder.end());
        vector<string> result;

        Node root;
        for (string path : folder) {
            istringstream iss(path);
            vector<string> segments;
            string segment;

            while (getline(iss, segment, '/')) {
                segments.push_back(segment);
            }

            if (root.insert(segments, 0)) {
                result.push_back(path);
            }
        }
        return result;
    }
};
