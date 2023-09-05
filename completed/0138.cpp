#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (head == NULL) {
            return NULL;
        }

        Node* current = head;
        map<Node*, int> originalNodes;
        vector<Node*> copiedNodes;
        while (current != NULL) {
            originalNodes.insert({ current, copiedNodes.size() });
            copiedNodes.push_back(new Node(current->val));
            if (copiedNodes.size() > 1) {
                copiedNodes[copiedNodes.size() - 2]->next = copiedNodes.back();
            }
            current = current->next;
        }

        current = head;
        for (int i = 0; current != NULL; i++) {
            if (current->random != NULL) {
                int j = originalNodes[current->random];
                copiedNodes[i]->random = copiedNodes[j];
            }
            current = current->next;
        }
        return copiedNodes[0];
    }
};

int main() {
    Node node1 = Node(7);
    Node node2 = Node(13);
    Node node3 = Node(11);
    Node node4 = Node(10);
    Node node5 = Node(1);
    node1.next = &node2;
    node2.next = &node3;
    node2.random = &node1;
    node3.next = &node4;
    node3.random = &node5;
    node4.next = &node5;
    node4.random = &node3;
    node4.random = &node1;

    Solution solution;
    auto current = solution.copyRandomList(&node1);
    while (current != NULL) {
        cout << current->val << ": ";
        if (current->next) {
            cout << "next = " << current->next << " ";
        }
        if (current->random) {
            cout << "random = " << current->random->val;
        }
        cout << endl;
        current = current->next;
    }
    return 0;
}