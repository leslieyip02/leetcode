import java.util.*;

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int totalLength = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            totalLength++;
        }

        int[] lengths = new int[k];
        Arrays.fill(lengths, totalLength / k);
        for (int i = 0; i < (totalLength % k); i++) {
            lengths[i]++;
        }

        currentNode = head;
        ListNode[] parts = new ListNode[k];
        for (int i = 0; i < k; i++) {
            if (currentNode == null) {
                break;
            }

            parts[i] = currentNode;
            for (int j = 0; j < lengths[i] - 1; j++) {
                currentNode = currentNode.next;
            }
            ListNode tmp = currentNode;
            currentNode = currentNode.next;
            tmp.next = null;
        }
        return parts;
    }
}
