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
        
        // S = [-1, 0, 1, 2, -1, -4],
        // sort = [-4, -1, -1, 0, 1, 2]
        // c = -4, find twoSum(nums, i+1, nums.length-1, -c)
        
        //Use 3 pointers - i, low, high
        //Use Hashset to get unique list.
        //Use Collections.addAll method to copy from HashSet to ArrayList.
       // Complexity : O(n2), Time : 78 ms
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int outer=0; outer<nums.length; outer++) { // num=c
            // use two pointers
            int start = outer+1;
            int end = nums.length-1;
            int twoSum = (-1) * nums[outer];
            
            if(outer !=0  && nums[outer] == nums[outer-1]) continue; 
            
            // two sum two pointer solution below
            while (start<end) {
                if (nums[start] + nums[end] == twoSum) {
                   // List<Integer> entry = new ArrayList<Integer>();
                    // add three integers
                    res.add(Arrays.asList(nums[start], nums[outer], nums[end]));
                    start++;
                    end--;
                    // Example: [-4, -1, -1, -1, -1, -1, -1, -1, 0, 1, 1, 1, 1, 1, 1, ]
                    while((start < end) && (nums[start] == nums[start-1]))
                        start++;// avoid duplicates
                    while((start < end) && (nums[end] == nums[end+1]))  // this end+1 will not go out of bound
                        end--;// avoid duplicates
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
