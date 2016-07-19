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
        HashMap<Integer, TreeLinkNode> hm = new HashMap<Integer, TreeLinkNode>();
        connect(0,root,hm);
    }
    
    public void connect(int level, TreeLinkNode root, HashMap<Integer, TreeLinkNode> hm) {
        
        if (root == null) return;
        
        if (!hm.containsKey(level)) {
            hm.put(level, node);
        }
        else {
            hm.get(level).addToListTail(hm.get(level), node);
        }
        
        connect(level+1, root.left, hm);
        connect(level+1, root.right, hm);
    }
    
    public TreeLinkNode addToListTail(TreeLinkNode head, TreeLinkNode node){
        while (head.next!=null)
            head = head.next;
        head.next = node;
        return head;
    }
}