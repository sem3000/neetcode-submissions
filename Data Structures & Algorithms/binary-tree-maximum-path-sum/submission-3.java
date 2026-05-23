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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        traverse(root);
        return maxSum;
    }
    public int traverse(TreeNode node)
    {
        if(node == null)
            return 0;
        
        int LH = Math.max(traverse(node.left),0);
        int RH = Math.max(traverse(node.right),0);

        maxSum = Math.max(maxSum, LH + node.val + RH);

        return Math.max(LH,RH) + node.val;
    }
}
