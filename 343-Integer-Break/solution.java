/*
Theoratically, it is better to keep breaking integers as close to 3 as possible (central to 3), it's good to have 2s and 4s. 

Table

n   sum   product
--------------------
n=2 1+1   1
n=3 2+1   2
n=4 2+2   4  (is this in the test case? My program shouldn't work for this case, but it accidentally works)
n=5 3+2   6
n=6 3+3   9
n=7 3+4   12
n=8 3+3+2 18
n=9 3+3+3 27
n=10 3+3+2+2 3*3*4=36
n=11 3+3+3+2 54
n=12 3+3+3+3 81
...
*/


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