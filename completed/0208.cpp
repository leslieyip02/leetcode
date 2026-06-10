class Trie {
private:
    struct TrieNode {
        bool is_terminal;
        shared_ptr<TrieNode> children[26];
    };

    TrieNode* root;

public:
    Trie() {
        root = new TrieNode();
    }

    void insert(string word) {
        TrieNode* current = root;
        for (char c : word) {
            int index = (int) c - 'a';
            if (current->children[index] == nullptr) {
                current->children[index] = new TrieNode();
            }
            current = current->children[index];
        }
        current->is_terminal = true;
    }
    
    bool search(string word) {
        TrieNode* current = root;
        for (char c : word) {
            int index = (int) c - 'a';
            current = current->children[index];
            if (current == nullptr) {
                return false;
            }
        }
        return current->is_terminal;
    }
    
    bool startsWith(string prefix) {
        TrieNode* current = root;
        for (char c : prefix) {
            int index = (int) c - 'a';
            current = current->children[index];
            if (current == nullptr) {
                return false;
            }
        }
        return current != nullptr;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
