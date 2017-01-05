public class Solution {
    public int findMin(int[] nums) {
        
        /*
        The minimum element must satisfy one of two conditions: 1) If rotate, A[min] < A[min - 1]; 2) If not, A[0]. Therefore, we can use binary search: check the middle element, if it is less than previous one, then it is minimum. If not, there are 2 conditions as well: If it is greater than both left and right element, then minimum element should be on its right, otherwise on its left.
        */
        
        if (nums.length == 1) return nums[0]; 
        if (nums.length == 2) return Math.min(nums[0],nums[1]); 
        
        int start = 0; 
        int end = nums.length-1; 

        while (start <= end) {
            
            int mid = start + (end-start)/2; 
            
            
            if (mid>0 && nums[mid] < nums[mid-1])    
                return nums[mid];
            
            // always look forward except this condition
            /* 
                [*] <=mid
              *
            *     
                    *
                      *
            */
            
            
            if (nums[mid] >= nums[start] && nums[mid] > nums[end]) { // mid is in the first half, go to the second to find min
                start = mid+1; 
            }
            else { // mid is in the second half, go to the first half to find min
                end = mid-1; 
            }
        }
        
        return nums[start];
        //return nums[mid]; 
    }
}
