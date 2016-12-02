/* Solution to 3Sum
https://leetcode.com/problems/3sum/
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        // find a+b = -c
        
        // Use two pointers after sorting.
        // a+b = -c
        // for each -c (i.e., O(N)), find a = -c-b in the rest of the nlogn
        
        /* Example: S = [-1, 0, 1, 2, -1, -4],
           sort = [-4, -1, -1, 0, 1, 2]
           c = -4, find twoSum(nums, i+1, nums.length-1, -c)
        */
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int outer=0; outer<nums.length; outer++) { // num=c
            // use two pointers
            int start = outer+1;
            int end = nums.length-1;
            int twoSum = (-1) * nums[outer];
            
            // avoid duplicate from the outer loop 
            // Example: [-4, -1, -1, -1, -1, -1, -1, -1, 0, 1], if -1 was visited from outer loop outer=1, we shouldn't vist the rest of "-1" again in the array from outer loop for outer = 2, 3, 4....
            if(outer !=0  && nums[outer] == nums[outer-1]) continue; 
            
            // two sum two pointer solution below
            while (start<end) {
                if (nums[start] + nums[end] == twoSum) {
                   // List<Integer> entry = new ArrayList<Integer>();
                    // add three integers
                    res.add(Arrays.asList(nums[start], nums[outer], nums[end]));
                    start++;
                    end--;
                    // Example: [-4, -1, -1, -1, -1, -1, -1, -1, 0, 1, 1, 1, 1, 1, 1]
                    // if -1 was visited from outer loop outer=1, we shouldn't vist the rest of "-1" in the array from outer loop. 
                    // avoid duplicates from inner loop -> start. When outer=1, nums[outer]=-1, nums[start]=-1 when start=2, we shouldn't visit the rest of "-1" again from inner loop where start = 3, 4, 5...
                    while((start < end) && (nums[start] == nums[start-1]))
                        start++;  
                    // avoid duplicates from inner loop <- end    
                    while((start < end) && (nums[end] == nums[end+1]))  // this end+1 will not go out of bound
                        end--;
                }
                
                else if (nums[start] + nums[end] < twoSum) {
                     start++;
                }
                
                else if (nums[start] + nums[end] > twoSum) {
                      end--;
                }
            }
        }
        return res;
    }
}
