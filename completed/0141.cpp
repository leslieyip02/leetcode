#include <iostream>
#include <set>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    bool hasCycle(ListNode *head) {
        set<ListNode*> visited;
        ListNode* current = head;
        while (current != NULL && current->next) {
            if (visited.find(current) != visited.end()) {
                return true;
            }
            visited.insert(current);
            current = current->next;
        }
        return false;
    }
};

int main() {
    ListNode node1 = ListNode(3);
    ListNode node2 = ListNode(2);
    ListNode node3 = ListNode(0);
    ListNode node4 = ListNode(-4);
    node1.next = &node2;
    node2.next = &node3;
    node3.next = &node4;
    node4.next = &node2;

    Solution solution;
    cout << (solution.hasCycle(&node1) ? "true" : "false") << endl;
    return 0;
}