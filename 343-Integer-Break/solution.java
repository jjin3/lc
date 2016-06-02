public class Solution {
    public int integerBreak(int n) {
        int product=1;
        if (n==2)
            return 1;
        if (n==3)
            return 2;
        while (n>4) {
            n = n - 3;
            product = product * 3; 
        }
        return n==0?product:product * n; 
    }
}