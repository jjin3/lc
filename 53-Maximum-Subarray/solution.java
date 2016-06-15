/*

This approach has a really low performance. 

Question E-121	Best Time to Buy and Sell Stock

+

Question E-303. Range Sum Query - Immutable

Example: 
nums array: [−2,1,−3,4,−1,2,1,−5,4]
sums array: [-2,-1,-4,0,-1,1,2,-3,1]

Sum range:
sums(2,6) = 2 - (-4) = 6

Potential test cases. 
test cases: Goes up [1,2,3,4,5] and [-5,-4,-3,-2,-1]
test cases: Goes down [5,4,3,2,1] and [-1,-2,-3,-4,-5]
test case: multiple peaks [1,3,1,5,2,4] and [-1,-3,-1,-5,-2,-4]

*/

public class Solution {
    
    // This is similar to E-121	Best Time to Buy and Sell Stock
    // Find the maximum difference between sum[j] and sum[i] (we call it minSum) and Max of (sum[j]-sum[i]) (we call it maxSumDiff).
    public int maxSubArray(int[] nums) {
        
        // maxSum must be located after minSum.
        // Step 1: Get the maxSumDiff first, which is presumably maxSumDiff(i-1).
        // Step 2: update the minSum 
        // keep a minimum before sums[i], which is sums[i-1].  The minimum value initialized as the first element of sums. 
        
        int[] sums = getSumRange(nums);
        int minSum = Math.min(0,sums[0]); // the current minimum Sum, this value is an "imagined" value before sum[0]. 
        
        int maxSumDiff=Integer.MIN_VALUE; // given any value
        int maxSumDiff_Prev = sums[0]; // the first element should be the max initially. 
        
        for (int i=1; i<sums.length; i++) {
            maxSumDiff = Math.max(sums[i] - minSum, maxSumDiff_Prev); // greedily find the current maxSumDiff
            minSum = Math.min(sums[i], minSum); // update minimum sum.
            maxSumDiff_Prev = maxSumDiff; // save the current maxSumDiff, which will be used as maxSumDiff(i-1) in the next iteration.
        }
        
        return nums.length==1?sums[0]:maxSumDiff;
    }
    
    // This is similar to E-303. Range Sum Query - Immutable
    public int[] getSumRange(int[] nums) {
        int[] sums = new int[nums.length];

        if (nums.length >= 1) {
            sums[0] = nums[0];
        }
        
        for (int i=1; i<nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        return sums;
    }
}