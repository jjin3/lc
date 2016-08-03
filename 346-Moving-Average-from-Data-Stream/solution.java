/*346. Moving Average from Data Stream

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

*/

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

/* 
If the comparison for "remove first" is between the ArrayList and the LinkedList classes, the LinkedList wins clearly.
Removing an element from a linked list costs O(1), while doing so for an array (array list) costs O(n).

Example

["MovingAverage","next","next","next","next"]
[[3],[1],[10],[3],[5]]
[null,1.00000,5.50000,4.66667,6.00000]

["MovingAverage","next","next","next","next","next","next","next","next","next","next"]
[[5],[12009],[1965],[-940],[-8516],[-16446],[7870],[25545],[-21028],[18430],[-23464]]

Output:
[null,12009.00000,6987.00000,4344.66650,1129.50000,-2385.60010,-3213.39990,1502.59998,-2515.00000,2874.19995,1470.59998]
Expected:
[null,12009.00000,6987.00000,4344.66667,1129.50000,-2385.60000,-3213.40000,1502.60000,-2515.00000,2874.20000,1470.60000]

*/

public class MovingAverage {

    public int windowSize = 0;
    private LinkedList<Integer> arr; 
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        arr = new LinkedList<Integer>(); 
        this.windowSize = size;
    }
    
    public double next(int val) {

        int n = 0; 
        arr.add(val);    

        // Continue to add new elements without deleting the previous element. 
        if (arr.size() <= this.windowSize) {
            n = arr.size();
        }
        else if (arr.size() > this.windowSize) {
            arr.poll();
            n = this.windowSize; 
        }

        int sum = 0; 
        for (Integer num : arr) {
           sum = sum + num;
        }
        return (1.00000) * sum / n;
    }
}

/*
 public class MovingAverage {
    private ArrayDeque<Integer> queue;
    private int size;
    private double sum;

    // Initialize your data structure here. 
    public MovingAverage(int size) {
        this.queue = new ArrayDeque<Integer>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > size) {
        	sum -= queue.removeFirst();
        }
    
	    return sum / (size > queue.size() ? queue.size() : size);
    }
}
*/