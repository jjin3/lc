
/*

Case 1: Target is in the list.
[1,3,5,6], 5 → 2

Case 2: Target were to be inserted in the middle.
[1,3,5,6], 2 → 1

Case 3: Target were to be inserted to the front, before the first element.
[1,3,5,6], 7 → 4

Case 4: Target were to be inserted after the last element.
[1,3,5,6], 0 → 0

*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        
        while (low <= high) {
            
            int mid = (low+high)/2;
            
            if (target == nums[mid]) {
                return mid;
            }
            else if (target > nums[mid]) {
                low = mid+1;
            }
            else if (target < nums[mid]) {
                high = mid-1;
            }
        }
        
        return low;
    }
}