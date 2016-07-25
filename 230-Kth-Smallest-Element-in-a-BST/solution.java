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

    public int kthSmallest(TreeNode root, int k) {
        return findKth(root, k, 0);
    }
    
    public int findKth(TreeNode root, int K, int step) {
        
        if (root == null) 
            return Integer.MAX_VALUE;
        
        if (findKth(root.left, K, step+1) == Integer.MAX_VALUE) // did not find the right val
            return Integer.MAX_VALUE;
            
        if (step==K) return root.val;
        
        if (findKth(root.right, k, step+1) == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
    }
}