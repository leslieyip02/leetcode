class FindElements {
private:
    static const int capacity = 1e6 + 1;
    vector<bool> exists;

    void populate(TreeNode* root) {
        int x = root->val;
        if (x >= capacity) {
            return;
        }
        exists[x] = true;
        if (root->left) {
            root->left->val = 2 * x + 1;
            populate(root->left);
          }
        if (root->right) {
            root->right->val = 2 * x + 2;
            populate(root->right);
        }
    }

public:
    FindElements(TreeNode* root) {
        exists.resize(capacity);
        root->val = 0;
        populate(root);
    }
    
    bool find(int target) {
        return exists[target];
    }
};
