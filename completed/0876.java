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
    public ListNode middleNode(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(head);
        while (head.next != null) {
            head = head.next;
            nodes.add(head);
        }
        return nodes.get(nodes.size() / 2);
    }
}
