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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> ans = new ArrayList<>();
        
        if(root == null)
          return ans;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            int n = q.size();

            for(int i=0; i<n-1; i++)
            {
                TreeNode a = q.poll();

                if(a.left != null)
                  q.offer(a.left);

                if(a.right != null)
                   q.offer(a.right);
            }

            TreeNode a = q.poll();
            ans.add(a.val);

            if(a.left != null)
                q.offer(a.left);
            if(a.right != null)
                q.offer(a.right);
        }

        return ans;
    }
}
