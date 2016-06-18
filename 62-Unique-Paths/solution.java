/*
<h1>2. Dynamic Programming with Two Arrays</h1>
Let's find a Dynamic Programming solution. Let's construct a 2-dimension array p[m][n], let's say matrix p. For the any cell (i,j) in this matrix p,

p[i][j] = p[i-1][j] + p[j-1][i];
where p[0][0] = 1 and i<m, j<n

What's the initial state? p[0][0] = 1;
p[1][1] = p[0][1] + p[1][0];
What's the value of p[0][j] and p[i][0] ??

*/


public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;
        
        int[][] p = new int[m][n];
        
        // The top row and left most row are all 1s, because there is only one way to go right only, or go down only. This is the DP initial state. 
        for (int i = 0; i < m; i++)
            p[i][0] = 1;
        for (int i = 1; i < n; i++)
            p[0][i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                p[i][j] = p[i - 1][j] + p[i][j - 1];
    
        return p[m - 1][n - 1];
    }
}