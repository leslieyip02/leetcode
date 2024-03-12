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
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }

        Stack<ListNode> nodes = new Stack<>();
        Stack<Integer> prefixes = new Stack<>();
        Set<Integer> previousPrefixes = new HashSet<>();

        int sum = 0;
        ListNode current = head;
        while (current != null) {
            sum += current.val;
            if (sum == 0) {
                nodes.clear();
                prefixes.clear();
                previousPrefixes.clear();
            } else if (previousPrefixes.contains(sum)) {
                while (prefixes.peek() != sum) {
                    nodes.pop();
                    int prefix = prefixes.pop();
                    previousPrefixes.remove(prefix);
                }
            } else {
                nodes.push(current);
                prefixes.push(sum);
                previousPrefixes.add(sum);
            }
            current = current.next;
        }

        if (nodes.isEmpty()) {
            return null;
        }

        Stack<ListNode> reversed = new Stack<>();
        while (!nodes.isEmpty()) {
            reversed.push(nodes.pop());
        }

        ListNode result = reversed.pop();
        result.next = null;
        current = result;
        while (!reversed.isEmpty()) {
            current.next = reversed.pop();
            current = current.next;
            current.next = null;
        }
        return result;
    }
}
