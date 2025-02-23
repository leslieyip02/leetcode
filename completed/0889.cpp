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
    TreeNode* trace(vector<int>& preorder, vector<int>& postorder) {
        if (postorder.empty()) {
            return NULL;
        }

        TreeNode* root = new TreeNode(postorder.back());
        postorder.pop_back();
        if (postorder.empty()) {
            return root;
        }

        auto itr = find(preorder.begin(), preorder.end(), postorder.back());
        if (itr == preorder.end()) {
            return root;
        }
        int index = itr - preorder.begin();

        int rightSize = preorder.size() - index;
        vector<int> rightPreorder(rightSize);
        vector<int> rightPostorder(rightSize);
        copy(preorder.begin() + index, preorder.end(), rightPreorder.begin());
        copy(postorder.end() - rightSize, postorder.end(), rightPostorder.begin());
        root->right = trace(rightPreorder, rightPostorder);

        int leftSize = index - 1;
        vector<int> leftPreorder(leftSize);
        vector<int> leftPostorder(leftSize);
        copy(preorder.begin() + 1, preorder.begin() + index, leftPreorder.begin());
        copy(postorder.begin(), postorder.begin() + leftSize, leftPostorder.begin());
        root->left = trace(leftPreorder, leftPostorder);
        return root;
    }

public:
    TreeNode* constructFromPrePost(vector<int>& preorder, vector<int>& postorder) {
        return trace(preorder, postorder);
    }
};
