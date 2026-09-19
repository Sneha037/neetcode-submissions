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
    public int goodNodes(TreeNode root) 
    {
        return check(root, Integer.MIN_VALUE);
    }

    public int check(TreeNode node, int ans)
    {
        if(node == null)
          return 0;

        int left = check(node.left, Math.max(ans, node.val));
        int right = check(node.right, Math.max(ans, node.val));

        if(node.val >= ans)
           return left + right + 1;

        return left + right;
    }
}
