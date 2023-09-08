#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        vector<ListNode*> parts(k, nullptr);

        int length = 0;
        ListNode* current = head;
        while (current != nullptr) {
            length++;
            current = current->next;
        }

        current = head;
        int m = length / k;
        int n = length % k;
        for (int i = 0; i < k && current != nullptr; i++) {
            parts[i] = current;
            auto tail = current;
            for (int j = 0; j < m - (i >= n); j++) {
                tail = tail->next;
            }
            current = tail->next;
            tail->next = nullptr;
        }
        return parts;
    }
};

int main() {
    ListNode node10 = ListNode(10);
    ListNode node9 = ListNode(9, &node10);
    ListNode node8 = ListNode(8, &node9);
    ListNode node7 = ListNode(7, &node8);
    ListNode node6 = ListNode(6, &node7);
    ListNode node5 = ListNode(5, &node6);
    ListNode node4 = ListNode(4, &node5);
    ListNode node3 = ListNode(3, &node4);
    ListNode node2 = ListNode(2, &node3);
    ListNode node1 = ListNode(1, &node2);
    int k = 3;

    Solution solution;
    auto results = solution.splitListToParts(&node1, k);
    for (auto part : results) {
        while (part != nullptr) {
            cout << part->val << " ";
            part = part->next;
        }
        cout << endl;
    }
    return 0;
}