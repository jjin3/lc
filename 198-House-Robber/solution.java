/*
This problem is solved with a greedy algorithm. 

The problem can be rephrased as 

For a sequence of numbers in the "nums" array, find the maximum sum where any two adjacent nums should not be selected.

For any given ith element in the nums array, to find the maximum sum, there must be two cases:

* ith element is selected, but (i-1)th element is NOT. And the (i-2)th element is selected. Therefore, there is a temporary maxProfit from nums_1 to nums_{i}. Let's find the maximum profit 

nums[i] + maxProfit(i-2); 

* ith element is not selected at all.

maxProfit(i-1)

Given the ith number in the sequence, nums_{1}, nums_{2},..., nums_{i}, we make a decision from the two cases, to determine the maximum profit (sum), whichever above is greater.

maxProfit (i) = Math.max(nums[i] + maxProfit(i-2),  maxProfit(i-1) )

Let's use maxProfit to represent maxProfit to make the program more readable. It's okay to have a maxProfit[] array, such that the length of maxProfit[] is nums.length. 

maxProfit[0] = nums[0];
maxProfit[1] = nums[1];

maxProfit[i] = Math.max(nums[i] + maxProfit[i-2], maxProfit[i-1]);

*/

public class Solution {
     public static int rob(int[] nums) {
         //  nums_{1}, nums_{2},..., nums_{i}..., nums{n}
         //  maxProfit (i) = Math.max(nums[i] + maxProfit(i-2),  maxProfit(i-1) )

         if (nums.length == 0) return 0;
         if (nums.length == 1) return nums[0];
         
         int[] maxProfit = new int[nums.length];
         
         // inital value.
         maxProfit[0] = nums[0];
         maxProfit[1] = Math.max(nums[0],nums[1]);
         
        if (nums.length == 2) return maxProfit[1];

        
         for(int i=2; i<nums.length;i++){
             maxProfit[i] = Math.max(nums[i] + maxProfit[i-2],  maxProfit[i-1]);
         }
         
         return maxProfit[nums.length-1];
        }
}



/*
// This is another simplified program, which takes out the sums[] array, and only use two variables as intermediate profits. 

public class Solution {
     public static int rob(int[] nums) {
         // X_n, X_{n-1},... X_1
         // M(n) = max {X_n+M(n-2), M(n-1)}
         int sum1 = 0;
         int sum2 = 0;
         
         for(int i =0;i<nums.length;i++){
             int temp = sum1;
             sum1 = Math.max(sum1, sum2);
             sum2 = temp + nums[i];
         }
         return Math.max(sum1, sum2);
        }
}

*/