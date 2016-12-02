public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int closestDiff = Integer.MAX_VALUE; 
        int diff=0, saveDiff=0;
        
        // find closet two sum where a+b+c ~ target
        // very similar to 3Sum problem: https://github.com/sproutoncloud/lc/blob/master/15-3sum-Medium.java
        
        for (int outer=0; outer<nums.length; outer++) {
            
            int start=outer+1;
            int end=nums.length-1; 
            
            // avoid dup from outer looper
            if(outer!=0 && nums[outer]==nums[outer-1])  
                outer++; 
            
            while(start<end) {
                diff = target - (nums[start] + nums[end] + nums[outer]); 
                int offsetDiff = Math.abs(diff); 
                
                if (offsetDiff==0) return target;
                
                // Test case: [-3,0,1,2]  1, must return 0. Shouldn't move start or end in this if statement, because at this point we don't know if we should move towards bigger sum (right) or (smaller sum) left. 
                if (offsetDiff<closestDiff)  {
                    closestDiff = offsetDiff; 
                    saveDiff = diff; 
                }
                else if (diff<0){  // Line 22: diff is negative, find something bigger to come closer to twoSumTarget
                    end--;
                }
                else if (diff>0) { // Line 22: diff is positive, find something smaller to come closer to twoSumTarget
                    start++;
                }
            }
        }
        return target - saveDiff; 
    }
}
