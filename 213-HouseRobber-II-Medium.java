public class Solution {
    
    public int rob(int[] nums) {

        if (nums.length==0)  return 0;
        if (nums.length==1)  return nums[0];
        if (nums.length==2)  return Math.max(nums[0], nums[1]);
        
                // To draw a circle, we found that if the first house (idx=0) is robbed, the thief would not select the last house (idx=nums.length-1). If the first house (idx=0) is NOT robbed, on the other hand, the thief is free to select (idx=nums.length-1). Let's image two arrays with index (0, length-2) and (1, length-1). These are two cases we would need to consider in this problem. It would not be more complicated than two cases, definitely NOT to think of a circulated array with n+1, n+2... 2n+1, 2n+2 etc.
        
        System.out.println(rob(nums, 0, nums.length-2));
        System.out.println(rob(nums, 1, nums.length-1));
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
    
    public int rob(int[] nums, int start, int end) {
        // there is a range. 
        int preMax = 0;
        int curMax = nums[start];
        
        /* Three variables
            curMax: max money can get if not rob i-1 th house
            preMax: max money can get if not rob i-1 th house
            max: the max value derived from equation at i th house by selecting previous houses. 
        */
        
        for (int i=start+1; i<=end; i++) {  // index starting from start+1 becuase nums[start] is already visited. 
            // for a particular i
            // equation: Math.max(preMax+nums[i], curMax);
            int max = Math.max(preMax+nums[i], curMax); // derive the i th max; 
            preMax = curMax;  // updating prevMax with current Max
            curMax = max;     // updaing curMax with the ith max; 
        }
        
        return curMax;
    }
}
