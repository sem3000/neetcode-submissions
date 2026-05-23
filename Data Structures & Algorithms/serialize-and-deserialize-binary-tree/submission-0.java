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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node == null)
            {
                sb.append("#,");
                continue;
            }

            sb.append(node.val+",");
            q.offer(node.left);
            q.offer(node.right);
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty())
            return null;

        String[] parts = data.split(",");
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        q.offer(root);

        for(int i=1; i<parts.length; i++)
        {
            TreeNode node = q.poll();

            if(!parts[i].equals("#"))
            {
                TreeNode leftNode = new TreeNode(Integer.parseInt(parts[i]));
                q.offer(leftNode);
                node.left = leftNode;
            }

            i++;
            if(!parts[i].equals("#") && i<parts.length)
            {
                TreeNode rightNode = new TreeNode(Integer.parseInt(parts[i]));
                q.offer(rightNode);
                node.right = rightNode;
            }
        }
        return root;
    }
}
