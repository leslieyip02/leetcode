#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    TreeNode* trace(int i, vector<pair<int, int>>& depths) {
        int value = depths[i].first;
        int depth = depths[i].second;
        TreeNode* current = new TreeNode(value);

        for (int j = i + 1; j < depths.size(); j++) {
            int otherDepth = depths[j].second;
            if (otherDepth == depth) {
                break;
            }

            if (otherDepth == depth + 1) {
                if (!current->left) {
                    current->left = trace(j, depths);
                } else {
                    current->right = trace(j, depths);
                    break;
                }
            }
        }
        return current;
    }

public:
    TreeNode* recoverFromPreorder(string traversal) {
        vector<pair<int, int>> depths;
        string value = "";
        int depth = 0;
        for (int i = 0; i < traversal.size(); i++) {
            if (traversal[i] == '-') {
                if (value != "") {
                    depths.push_back(make_pair(stoi(value), depth));
                    value = "";
                    depth = 0;
                }
                depth++;
            } else {
                value += traversal[i];
            }
        }
        depths.push_back(make_pair(stoi(value), depth));
        return trace(0, depths);
    }
};
