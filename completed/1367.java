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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean trace(ListNode head, TreeNode root, boolean started) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (started) {
            return root.val == head.val && (trace(head.next, root.left, true) | trace(head.next, root.right, true));
        }

        return trace(head, root.left, false) | trace(head, root.right, false) |
            (root.val == head.val && (trace(head.next, root.left, true) | trace(head.next, root.right, true)));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        return trace(head, root, false);
    }
}
