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
    func addGrandchildren(_ root: TreeNode?) -> Int {
        var sum = 0
        if let left = root?.left {
            sum += left.left?.val ?? 0
            sum += left.right?.val ?? 0
        }
        if let right = root?.right {
            sum += right.left?.val ?? 0
            sum += right.right?.val ?? 0
        }
        return sum
    }

    func traverseTree(_ root: TreeNode?) -> Int {
        if root == nil {
            return 0
        }

        var sum = traverseTree(root!.left) + traverseTree(root!.right)
        if root!.val % 2 == 0 {
            sum += addGrandchildren(root)
        }
        return sum
    }

    func sumEvenGrandparent(_ root: TreeNode?) -> Int {        
        return traverseTree(root)
    }
}
