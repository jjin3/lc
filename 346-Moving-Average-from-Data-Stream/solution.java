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

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */