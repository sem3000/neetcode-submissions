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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return traverse(root,subRoot);
    }
    public boolean traverse(TreeNode node, TreeNode subNode)
    {
        if(node == null)
            return false;

        if(check(node, subNode))
        {
            return true;
        }
        
        return (traverse(node.left, subNode) || traverse(node.right, subNode));
    }
    public boolean check(TreeNode node, TreeNode subNode)
    {
        if(node == null && subNode == null)
            return true;
        if(node == null || subNode == null)
            return false;

        if(node.val != subNode.val)
            return false;
        
        return(check(node.left, subNode.left) && check(node.right, subNode.right));
    }
}
