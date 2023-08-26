#include <iostream>
#include <vector>
#include <set>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
private:
    TreeNode* generateTree(vector<int>& order) {
        TreeNode* root = new TreeNode(order.front());
        for (int i = 1; i < order.size(); i++) {
            TreeNode* current = root;
            while (true) {
                if (order[i] > current->val) {
                    if (current->right == nullptr) {
                        TreeNode* leaf = new TreeNode(order[i]);
                        current->right = leaf;
                        break;
                    } else {
                        current = current->right;
                    }
                } else {
                    if (current->left == nullptr) {
                        TreeNode* leaf = new TreeNode(order[i]);
                        current->left = leaf;
                        break;
                    } else {
                        current = current->left;
                    }
                }
            }
        }
        return root;
    }

public:
    vector<TreeNode*> generateTrees(int n) {
        vector<TreeNode*> trees;
        set<vector<int>> existing;
        vector<int> order(n);
        for (int i = 0; i < n; i++) {
            order[i] = i + 1;
        }
        trees.push_back(generateTree(order));

        int i = 1;
        vector<int> c(n);
        while (i < n) {
            if (c[i] < i) {
                if (i % 2 == 0) {
                    swap(order[0], order[i]);
                } else {
                    swap(order[c[i]], order[i]);
                }
                auto tree = generateTree(order);
                vector<int> values;
                treeToVector(tree, values);
                if (existing.find(values) == existing.end()) {
                    trees.push_back(tree);
                    existing.insert(values);
                }

                c[i] += 1;
                i = 1;
            } else {
                c[i] = 0;
                i += 1;
            }
        }
        return trees;
    }

    void treeToVector(TreeNode* root, vector<int>& values) {
        if (root != nullptr) {
            values.push_back(root->val);
            treeToVector(root->left, values);
            treeToVector(root->right, values);
        }
    }
};

int main() {
    int n = 3;
    // int n = 1;

    Solution solution;
    vector<TreeNode*> results = solution.generateTrees(n);
    for (TreeNode* result : results) {
        vector<int> values;
        solution.treeToVector(result, values);
        for (int value : values) {
            cout << value << " ";
        }
        cout << endl;
    }
    return 0;
}