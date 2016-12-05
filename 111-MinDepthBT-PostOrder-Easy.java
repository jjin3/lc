/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {

        if (root==null)
            return 0; 
        
        // if one of the child is null, only look for the min of the other child 
        if (root.left == null || root.right == null)
            return minDepth(root.left) + minDepth(root.right) + 1;
            
        return Integer.min(minDepth(root.left) + 1, minDepth(root.right) + 1);

    }
}
