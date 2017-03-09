/*

word1: Saturday
word2: Sundays 

  Sunyday
 01234567
S10123456
a21123345
t32223445
u43233455
r54334456
d65443456
a76554345
y87665434

*/

public class Solution {
    public int minDistance(String word1, String word2) {
        
        int r = word1.length(); 
        int c = word2.length();
        
        int grid[][] = new int[r+1][c+1];  // m rows and n columns

        for (int i=0; i<=r; i++) 
            grid[i][0] = i; 
        for (int j=0; j<=c; j++) 
            grid[0][j] = j; 

        for (int i=1; i<=r; i++) 
            for (int j=1; j<=c; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))  
                    grid[i][j] = grid[i-1][j-1]; 
                
                else {
                    grid[i][j] = Math.min(Math.min(grid[i-1][j-1], grid[i][j-1]), grid[i-1][j]) + 1; 
                }
            }
        return grid[r][c];
    }
}
