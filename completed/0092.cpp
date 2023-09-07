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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if (left == right) {
            return head;
        }

        right -= (left - 1);
        ListNode* tmp = new ListNode(-1, head);
        ListNode* current = tmp;
        ListNode* previous = nullptr;
        while (left--) {
            previous = current;
            current = current->next;
        }

        ListNode* start = previous;
        ListNode* end = current;
        while (right--) {
            ListNode* next = current->next;
            current->next = previous;
            previous = current;
            current = next;
        }
        start->next = previous;
        end->next = current;
        return tmp->next;
    }
};

int main() {
    // ListNode* node5 = new ListNode(5);
    // ListNode* node4 = new ListNode(4, node5);
    // ListNode* node3 = new ListNode(3, node4);
    // ListNode* node2 = new ListNode(2, node3);
    // ListNode* node1 = new ListNode(1, node2);
    // int left = 2;
    // int right = 4;
    // ListNode* node5 = new ListNode(5);
    // ListNode* node4 = new ListNode(4, node5);
    // ListNode* node3 = new ListNode(3, node4);
    // ListNode* node2 = new ListNode(2, node3);
    // ListNode* node1 = new ListNode(1, node2);
    // int left = 1;
    // int right = 5;
    ListNode* node1 = new ListNode(5);
    int left = 1;
    int right = 1;

    Solution solution;
    auto result = solution.reverseBetween(node1, left, right);
    while (result != nullptr) {
        cout << result->val << " ";
        result = result->next;
    }
    cout << endl;
    return 0;
}