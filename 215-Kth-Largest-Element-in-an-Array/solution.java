public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // What data structure should we apply to this problem? Is that minHeap or maxHeap? As we process the given input, we want to track the kth largest number seen so far.  Suppose at certain point, we construct a heap with K integers, what if the (k+1)th element come in? If the next incoming (k+1)th element is bigger than the min in the heap, we need minHeap deletion with O(log(n)) and minHeap insertion with O(log(n));
       /* To summarize heap (PriorityQueue in Java)
          minHeap or maxHeap supports
          O(log(n)) insertion
          O(1) time lookup for maxinum or minimum
          O(log(n)) deletion
          Problems require K largest: minHeap
          Problems require K smllest maxHeap
          Java important methods: 
             A custom comparator in the heap constructor
             (1) PriorityQueue (int capacity)  --> Natural Order
             (2) PriorityQueue (int capacity, new Comparator<Object>() {
                    public int compare(Object a, Object b) {
                        return SomeGenericClass.compare(a,b)
                    }          
                })                             --> Use Comparator to determine Order
             (3) add(element)
             (4) peek()
             (5) poll()
       */
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for(Integer num: nums) {
            if (minHeap.size() < k)
                minHeap.add(num);
            else if (minHeap.peek() < num) {
                // the number should be inserted to the priority, and before that delete the min.
                minHeap.poll();
                minHeap.add(num);
            }
            // for the case minHeap.peek() > num, do nothing because the number is too small to be included in the Kth largest minHeap.
        }
        return minHeap.peek();
    }
}