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
    public boolean isBalanced(TreeNode root) {
        if(height(root) == -1)
            return false;
        return true;
    }
    public int height(TreeNode node)
    {
        if(node == null)
            return 0;

        int LH = height(node.left);
        if(LH == -1)
            return -1;
        int RH = height(node.right);
        if(RH == -1)
            return -1;

        if(Math.abs(LH-RH) > 1)
            return -1;

        return 1 + Math.max(LH,RH);
    }
}
