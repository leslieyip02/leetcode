/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */
class Solution {
    func helper(_ inorder: ArraySlice<Int>, _ postorder: ArraySlice<Int>) -> TreeNode? {
        guard !inorder.isEmpty else {
            return nil
        }

        let rootVal = postorder.last!
        let rootIndex = inorder.index(of: rootVal)! - inorder.startIndex

        let root = TreeNode(rootVal)
        root.left = helper(
            inorder[inorder.startIndex..<(inorder.startIndex + rootIndex)],
            postorder[postorder.startIndex..<(postorder.startIndex + rootIndex)]
        )
        root.right = helper(
            inorder[(inorder.startIndex + rootIndex + 1)...],
            postorder[(postorder.startIndex + rootIndex)..<(postorder.endIndex - 1)]
        )
        return root
    }

    func buildTree(_ inorder: [Int], _ postorder: [Int]) -> TreeNode? {
        return helper(inorder[...], postorder[...])
    }
}
