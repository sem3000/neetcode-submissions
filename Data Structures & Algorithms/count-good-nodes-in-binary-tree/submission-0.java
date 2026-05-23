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
    private int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        traverse(root, root.val);
        return count;
    }
    public void traverse(TreeNode node, int max)
    {
        if(node == null)
            return;
        
        if(node.val >= max)
            count++;

        max = Math.max(max, node.val);
        traverse(node.left, max);
        traverse(node.right, max);
    }
}
