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
    int height(TreeNode *root) {
        return root == NULL ? 0 : 1 + height(root->left);
    }

public:
    int countNodes(TreeNode *root) {
        if (root == NULL) {
            return 0;
        }

        int leftHeight = height(root->left);
        int rightHeight = height(root->right);
        return leftHeight == rightHeight
            ? (1 << leftHeight) + countNodes(root->right)
            : (1 << rightHeight) + countNodes(root->left);
    }
};
