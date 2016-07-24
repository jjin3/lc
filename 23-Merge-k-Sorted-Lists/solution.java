/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // Brute force approach: delete one element at a time, and insert into the result linked list. Time complexity: O(KN * KN). N is the average length of each list. The first KN comes from the scan of all elements. The second KN is the worse case from inserting to result array. Similar to insertion sort. 
        // K pointers appraoch: O(KN), why? find min O(K) and move one step of a pointer O(KN)
        
        // BuildMinHeap: minHeap
        // minHeap has a comparator class compare value of any two ListNodes. 
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare (ListNode a, ListNode b) {
                return Integer.compare(a.val, b.val);
            }
        });
        
        // Define a result linkedlist
        ListNode res = null;
        
        // Covert a list[] array to Arraylist for simpler removal later. 
        ArrayList<ListNode> input = new ArrayList<ListNode>(lists.length);
        for (ListNode list : lists) {   // O(K)
            if (list != null) {
                input.add(list);   
                minHeap.add(list); // add initial K element to the minHeap. 
            } 
        }
        
        // If the input lists still have non empty element, go process it. Once the lists eventually diminished, the process completes. 
        while (input.size() != 0) {
            // An important question is, how to pop() element and add new element to minHeap? 
            // The first thought is round robin to pop() element from each list, and add to the minHeap. however, this is not correct, think of an exmaple (1->2->3), (11->12->13) , (21->22->23), First time add 1, 11 and 21, the second time add 2, 12 and 22. this will be out of order, 1, 2, 11, 12,...3,...
            // The figure xx shows the idea of getting the right order 
            
            // THis is the poll process
            for (ListNode head : input) {
                if (head != null) { // The current list is not null. 
                    // before add new element to the minHeap, Extract minimum value from minHeap: minHeap.poll()
                    // This guarantees to be the smallest among all candidate nodes because we add the first node of all lists to minHeap as the initial state. 
                    ListNode node = minHeap.poll(); 
                    
                    // right after it polls, immediately add to result list.
                    if (res == null) 
                        res = node;
                    else {
                        res.next = node;
                        res = res.next;
                    }
                    
                    // whoever being polled, I want it's next element: This is the right element being insert to minHeap agai.
                    if (node.next != null)
                        minHeap.add(node.next); // Trim the original lists. This null list should be removed from the input lists array. 
                }
            }
        }
        
        return res;
    }
}