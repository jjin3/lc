public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        
        Arrays.sort(nums);
        int count=0;
        
        for (int outer=0; outer<nums.length; outer++) {
            
            int start = outer+1; 
            int end=nums.length-1;

            while(start<end) {
                
                int sum = nums[outer] + nums[start] + nums[end];
                
                if (sum < target) {
                    // Example: [-2, 0, 1, 1, 2, 3]  4
                    // -2, 0, 3, sum = 1 < 4, which means all elements between 0 and 3 should be selected.
                    // -2, 0, 2, sum = 0 < 4, which means all elements between 0 and 2 should be selected. 
                    // same as for "1" at index 2 and "1" at index 3

                    count += end-start;
                    // move towards bigger sum
                    start++; 
                }
                else {
                    // move towards smaller sum
                    end--; 
                } 
            }
            
        }
        return count; 
    }
}
