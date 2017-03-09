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
        
        int grid[][] = new int[word1.length()+1][word2.length()+1];  // m rows and n columns

        for (int i=0; i<=word1.length(); i++) 
            grid[i][0] = i; 
        for (int j=0; j<=word2.length(); j++) 
            grid[0][j] = j; 

        for (int i=1; i<=word1.length(); i++) 
            for (int j=1; j<=word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))  
                    grid[i][j] = grid[i-1][j-1]; 
                
                else {
                    grid[i][j] = Math.min(Math.min(grid[i-1][j-1], grid[i][j-1]), grid[i-1][j]) + 1; 
                }
            }
            
        for (int i=0; i<=word1.length(); i++) {
            for (int j=0; j<=word2.length(); j++)
                System.out.print(grid[i][j]);    
            System.out.println();
        }
            
        return grid[word1.length()][word2.length()];
    }
}
