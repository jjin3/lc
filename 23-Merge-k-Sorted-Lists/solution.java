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
        
        // Idea 1: Brute force approach: delete one element at a time, and insert into the result linked list. Time complexity: O(KN * KN). N is the maximum length of each list. The first KN comes from the scan of all elements. The second KN is the worse case from inserting to result array. Similar to insertion sort. 
        // Idea 2: K pointers appraoch: O(KN), why? find min O(K) and move one step of a pointer O(KN * K)
        
        
        
        // Idea 3: BuildMinHeap: minHeap
        // minHeap has a comparator class compare value of any two ListNodes. 
        // Overall Complexity: O(kn * logK) = O(knLog(K)): always keep the size of minHeap less or equal to K. 
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare (ListNode a, ListNode b) {
                return Integer.compare(a.val, b.val);
            }
        });
        
        // Define a result linkedlist
        ListNode res = null; // head
        ListNode tail = null; // record the end of result list, append to tail. 

        // initial state
        for (ListNode list : lists) {   // O(K)
            if (list != null) {
                minHeap.add(list); // add initial K head element to the minHeap. 
            } 
        }
        
        // THis is the poll process
        while (!minHeap.isEmpty()) {
            // An important question is, how to move listNode element and add new element to minHeap? 
            // The first thought is round robin to pop() element from each list, and add to the minHeap. however, this is not correct, think of an exmaple (1->2->3), (11->12->13) , (21->22->23), First time add 1, 11 and 21, the second time add 2, 12 and 22. this will be out of order, 1, 2, 11, 12,...3,...
            // The figure xx shows the idea of getting the right order 
            
            // before add new element to the minHeap, Extract minimum value from minHeap: minHeap.poll()
            // This guarantees to be the smallest among all candidate nodes because we add the first node of all lists to minHeap as the initial state. 
            ListNode node = minHeap.poll(); // O(log(k))
                    
            // right after it polls, immediately add to result list.
            if (res != null) {
                tail.next = node;
                tail = tail.next;
            }
            else {
                res = node;
                tail = res;
            }
                    
            // whoever being polled, we want it's next element: This is the exact element should be inserted to minHeap agai.
            if (node.next != null)
                minHeap.add(node.next); 
            // else: Naturally trim the original lists if next is null
        }
        
        return res;
    }
}