public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        
        
        int pre_zero = -1; 
        int left = 0;   // number of ones of to the left side of current zero. 
        int max=-1; 
        int count=0;  // count the number of ones. In other words, this is the right side of number of ones for current zero. 
        boolean flipped = false; 
        /* 
        [1,0,1,1,0]
        */
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {

                max = Math.max(left + 1 + count, max);  // add up left side, current 0, and right side. 
                flipped = true; 
                count = 0;  // whenever it's a 0, reset the counter to 0; 
                left = i - pre_zero - 1;  // keep track of the previous number of 1s between two 0s.  x x 0 [x x x] 0 x x x
                pre_zero = i;
            }
            else if (nums[i] == 1) {
                count++; 
            }
        }
        
        if (!flipped)
            return Math.max(count, max);
        return Math.max(left + 1 + count, max); 
    }
}
