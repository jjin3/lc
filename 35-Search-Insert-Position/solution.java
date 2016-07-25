public class Solution {
    public int searchInsert(int[] nums, int target) {
        int high = nums.length;
        int low = 0;
        int mid = (0 + nums.length)/2;
        
        if (target > nums[nums.length-1]) return nums.length;
        
        while (low < high) {
            if (target > nums[mid]) {
                low = mid;
                mid = (low+high)/2;
            }
            else if (target < nums[mid]) {
                high = mid;
                mid = (low+high)/2;
            }
            else if (target == nums[mid]) {
                return mid;
            }
        }
        
        return mid;
    }
}