/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    //public static int level=0;
    public void connect(TreeLinkNode root) {
        HashMap<Integer, LinkedList<TreeLinkNode>> hm = new HashMap<Integer, LinkedList<TreeLinkNode>>();
        connect(0,root,hm);
    }
    
    public void connect(int level, TreeLinkNode root, HashMap<Integer, LinkedList<TreeLinkNode>> hm) {
        
        if (root == null) return;
        
        if (!hm.containsKey(level)) 
            hm.put(level, new LinkedList<TreeLinkNode>());
        else {
            hm.get(level).add(root);
        }
        
        connect(level+1, root.left);
        connect(level+1, root.right);
    }
}