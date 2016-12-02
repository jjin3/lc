public class Solution {
    public int rob(int[] nums) {
        
        if (nums.length==0) return 0; 
        
        // find the maximum of (nums[i] + sum(i-2), sum(i-1))
        
        int maxSum = nums[0]; // i = 0
        int curMaxSum = maxSum; 
        int preMaxSum = 0; // previous sum of i=0, which must be zero. think of it as a -1 index; 
        for (int i=1; i<nums.length; i++) {
            maxSum = Math.max(nums[i] + preMaxSum, curMaxSum);
            preMaxSum = curMaxSum; 
            curMaxSum = maxSum; 
        }
        
        /*
        10, 2, 4, 3
        i=0 10, curMaxSum = 10, preMaxSum = 0
        i=1 2, curMaxSum = 10, maxSum = max(2+0, 10) = 10, so preMaxSum = 10
        i=2 4, curMaxSum = 10, preMaxSum = 10, maxSum = max(10+4, 10) = 14, so preMaxSum = 10, curMaxSum = 14
        i=3 3, curMaxSum = 14, preMaxSum = 10, maxSum = max(10+3, 14) = 14
        */
        return maxSum;
    }
}
