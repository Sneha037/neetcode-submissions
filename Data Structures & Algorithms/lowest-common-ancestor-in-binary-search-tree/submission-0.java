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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root == null)
          return null;

        if(root.val == p.val || root.val == q.val)
        {
            return root;
        }
        
        if((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > 
        q.val))
        {
            return root;
        }

        if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
    }

    public boolean check(TreeNode node, TreeNode a)
    {
        if(node == null)
           return false;

        if(node.val == a.val)
          return true;

        if(a.val < node.val)
          return check(node.left, a);

        return check(node.right, a);
    }
}
