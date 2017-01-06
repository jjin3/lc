public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1; 
        
        
        while (end>=0 && nums[0] == nums[end]) {
            end--; 
        }
        
        
        while (start <= end) {
            int mid = start + (end-start)/2; 
            
            // MID is the minimum. 
            if (mid > 0 && nums[mid] < nums[mid-1])
                return nums[mid];
                
            // go to the right half
            if (nums[mid] >= nums[start] && nums[mid] > nums[end])
                start = mid+1; 
            
            // go to the left half for all other cases; 
            
            /*  Explaining why all other cases fall under this scenario. 
            start<mid<end
                &                 
              &           
            &           
            
            start>mid and end>mid
             &
                  &
                &
                
            start=mid and end<mid
             &
                  
                &    
            
            start=mid and end>mid
               &
            &       
            
            */
            else
                end = mid-1; 
            
        }
        
        // if start and end meet, the meet point is the minimum. 
        return nums[start]; 
        
    }
}
