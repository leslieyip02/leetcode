#include <iostream>
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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int v = l1->val + l2->val;
        int c = v / 10;
        ListNode* l = new ListNode(v % 10);
        ListNode* current = l;
        l1 = l1->next;
        l2 = l2->next;
        while (!(l1 == nullptr && l2 == nullptr && c == 0)) {
            int v1 = l1 == nullptr ? 0 : l1->val;
            int v2 = l2 == nullptr ? 0 : l2->val;
            v = v1 + v2 + c;
            c = v / 10;
            current->next = new ListNode(v % 10);
            current = current->next;
            if (l1 != nullptr) {
                l1 = l1->next;
            }
            if (l2 != nullptr) {
                l2 = l2->next;
            }
        }
        return l;
    }
};

int main() {
    ListNode a1(9);
    ListNode a2(4, &a1);
    ListNode l1(2, &a2);
    ListNode b1(9);
    ListNode b2(4, &b1);
    ListNode b3(6, &b2);
    ListNode l2(5, &b3);

    Solution solution;
    ListNode* l = solution.addTwoNumbers(&l1, &l2);
    while (l != nullptr) {
        cout << l->val << ' ';
        l = l->next;
    }
    cout << endl;
    return 0;
}
