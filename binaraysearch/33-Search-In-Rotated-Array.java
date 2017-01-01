public class Solution {
    
    /*
    
    Case 1: nums[low] <= nums[mid]
    
        [*] <--- MID
      *
    *
                *
              *
            *  
    Left before mid is a normal sorted increasing array.  
              
    Case 2: nums[low] > nums[mid] 
    
        *
      *
    * 
                  *
                *
              *  
           [*] <----- MID
    
    Right after MID is a normal sorted increasing array.           
    */
    
    public int search(int[] nums, int target) {
        
        int low = 0; 
        int high = nums.length-1; 
        
        while (low<=high) {
            int mid = low+(high-low)/2; 
            
            if (target == nums[mid])
                return mid; 
            
            if (target == nums[low])
                return low; 
                
            if (nums[low] <= nums[mid]) {  // an increasing sequence
                if (target < nums[mid] && target > nums[low]) 
                    high = mid-1; 
                else 
                    low = mid+1; 
            }
            else {  // there is a turning point between low and mid
                if (target > nums[mid] && target < nums[low])
                    low = mid+1; 
                else  
                    high = mid-1; 
            }
        }
        
        return -1; 
    }
}
