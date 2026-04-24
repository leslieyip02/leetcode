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
public:
    int maxLevelSum(TreeNode* root) {
        queue<TreeNode*> nodes;
        nodes.push(root);

        int x = 1;
        int maximal = root->val;

        int level = 1;
        while (!nodes.empty()) {
            int sum = 0;
            int count = nodes.size();
            for (int i = 0; i < count; i++) {
                TreeNode* current = nodes.front();
                nodes.pop();
                sum += current->val;

                if (current->left) {
                    nodes.push(current->left);
                }
                if (current->right) {
                    nodes.push(current->right);
                }
            }

            if (sum > maximal) {
                x = level;
                maximal = sum;
            }

            level++;
        }

        return x;
    }
};
