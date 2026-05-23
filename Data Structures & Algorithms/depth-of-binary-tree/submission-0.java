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
    int ans = 0;
    public int maxDepth(TreeNode root) {
        traverse(root,1);
        return ans;
    }
    public void traverse(TreeNode node, int depth)
    {
        if(node == null)
            return;
        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
        ans = Math.max(ans,depth);
    }
}
