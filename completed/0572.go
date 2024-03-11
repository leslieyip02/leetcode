/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func ok(root *TreeNode, subRoot *TreeNode) bool {
    if root == nil || subRoot == nil {
        return root == subRoot
    }

    if root.Val != subRoot.Val {
        return false
    }

    return ok(root.Left, subRoot.Left) && ok(root.Right, subRoot.Right)
}


func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
    return ok(root, subRoot) || root != nil && (isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot))
}
