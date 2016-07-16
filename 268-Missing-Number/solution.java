public class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        return xor(length) ^ xor(nums);
    }
    
    public int xor(int[] arr) {
        int val = 0;
        for (int each:arr) {
            val = each ^ val;
        }
        return val;
    }
    
    public int xor(int n) {
        int val = 0;
        for (int i=0; i<=n; i++) {
            val = i ^ val;
        }
        return val;
    }
}