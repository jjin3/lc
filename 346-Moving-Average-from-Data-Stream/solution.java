public class MovingAverage {
    private ArrayDeque<Integer> queue;
    private int size;
    private double sum;

    /** Initialize your data structure here. */
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

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */