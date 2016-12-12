// Properties: Each node in the BST is itself a BST
// if both p and q are at the left side of the tree, go to left child of root 
// if both p and q are at the right side of the tree, go to right child of root
// if one of them at left side, and the other one in right side, return root. 

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Binary search tree
        if (root == null)
            return null; 
        // if both p and q are at the left side of the tree, go to left child
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q); 
        // if both p and q are at the right side of the tree, go to right child of root
        else if (p.val > root.val && q.val > root.val)        
            return lowestCommonAncestor(root.right, p, q); 

        return root; 
    }
}
