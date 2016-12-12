/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        int carry = 0; 
        ListNode head = null; 
        while(!s1.isEmpty() || !s2.isEmpty()) {
            
            if (!s1.isEmpty() && !s2.isEmpty())
                sum = s1.pop() + s2.pop() + carry;
            else if (s2.isEmpty()) 
                sum = s1.pop() + carry; 
            else if (s1.isEmpty()) 
                sum = s2.pop() + carry; 
                
            ListNode newNode = new ListNode(sum%10); 
            
            if (head == null) {
                head = newNode; 
            }
            else {
                //System.out.println("printout");
                newNode.next = head; 
                head=newNode; 
            }
            carry = sum/10; 
        }
        
        if (s1.isEmpty() && s2.isEmpty() && carry==1) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head; 
            head = newNode; 
        }
        return head; 
    }
}
