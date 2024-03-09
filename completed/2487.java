/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> nodes = new Stack<>();
        nodes.push(head);
        while (nodes.peek().next != null) {
            nodes.push(nodes.peek().next);
        }

        int max = nodes.peek().val;
        ListNode tail = nodes.pop();
        while (!nodes.empty()) {
            ListNode current = nodes.pop();
            if (current.val >= tail.val) {
                current.next = tail;
                tail = current;
            }
        }
        return tail;
    }
}
