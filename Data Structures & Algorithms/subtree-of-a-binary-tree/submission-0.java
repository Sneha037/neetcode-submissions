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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        if(root == null && subRoot == null)
           return true;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode a = q.poll();

            boolean ans = check(a, subRoot);

            if(ans)
              return ans;

            if(a.left != null)
               q.offer(a.left);

            if(a.right != null)
               q.offer(a.right);
        }
        
        return false;
    }

    public boolean check(TreeNode node, TreeNode subRoot)
    {
        if(node == null && subRoot == null)
          return true;

        if(node == null || subRoot == null)
          return false;

        if(node.val == subRoot.val)
            return check(node.left, subRoot.left) && check(node.right, subRoot.right);

        return false;
    }
}
