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
class BSTIterator {
private:
    stack<TreeNode *> visited;

public:
    BSTIterator(TreeNode *root) {
        TreeNode *current = root;
        while (current != NULL) {
            visited.push(current);
            current = current->left;
        }
    }
    
    int next() {
        TreeNode *current = visited.top();
        if (current->right != NULL) {
            visited.push(current->right);
            while (visited.top()->left != NULL) {
                visited.push(visited.top()->left);
            }
        } else {
            visited.pop();
            while (!visited.empty() && visited.top()->val < current->val) {
                visited.pop();
            }
        }
        return current->val;
    }
    
    bool hasNext() {
        return !visited.empty();
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
