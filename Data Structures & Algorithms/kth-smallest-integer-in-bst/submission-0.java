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
    int ans;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        count = 0;
        inOrder(root,k);
        return ans;
    }
    public void inOrder(TreeNode node, int k)
    {
        if(node == null)
            return;

        inOrder(node.left, k);
        count++;
        if(count == k)
        {
            ans = node.val;
            return;
        }
        if(count <=k)
            inOrder(node.right, k);
    }
}
