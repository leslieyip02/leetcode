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
    ListNode* partition(ListNode* head, int x) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }

        ListNode* end = head;
        int length = 1;
        while (end->next != nullptr)
        {
            end = end->next;
            length++;
        }

        ListNode dummy(-2000, head);
        ListNode* current = &dummy;
        while (length--)
        {
            if (current->next != end && current->next->val >= x)
            {
                auto tmp = current->next->next;
                end->next = current->next;
                end = end->next;
                end->next = nullptr;
                current->next = tmp;
            }
            else
            {
                current = current->next;
            }
        }

        return dummy.next;
    }
};

int main() {
    ListNode n5(2);
    ListNode n4(5, &n5);
    ListNode n3(0, &n4);
    ListNode n2(3, &n3);
    ListNode n1(4, &n2);
    ListNode head(1, &n1);
    int x = 2;

    Solution solution;
    ListNode* p = solution.partition(&head, x);
    while (p != nullptr)
    {
        cout << p->val << ' ';
        p = p->next;
    }
    cout << endl;
    return 0;
}
