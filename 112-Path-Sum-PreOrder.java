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
    
    public boolean hasPathSum(TreeNode root, int sum) {
        
        // root is null, no value at all, it returns false as there is no value equals to sum
        if(root==null) return false; 
        
        // if root is the leave node, and the value of root equals to current sum. 
        if(root.left == null && root.right == null && root.val == sum ) return true;
        
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val); 
    }
}
