public class Solution {
    
    public int numDecodings(String s) {
        
        if(s == null) return 0; 
        
        int n = s.length(); 
        if (n == 0 || (n>=1 && s.charAt(0) == '0')) return 0; 
        if (n==1) return 1; 
        
        // memo array index and string length match.
        int[] memo = new int[s.length()+1]; 
        Arrays.fill(memo,-1);
        memo[0] = 1; // although empty string should return '0', I set it up purposely for an empty string as initial step.
        memo[1] = 1; // for n=1, an one digit string
        
        return numDecodings(memo, s);
    }
    
    
    public int numDecodings(int[] memo, String s) {

        int n = s.length();

        if (memo[n] != -1) return memo[n]; // memo array index and string length match, so return memo[n] instead of memo[n-1]

        int numOfWays = 0; 
        
        // if the last digit is greater than 0. 
        if (s.charAt(n-1) > '0') {
            numOfWays = numOfWays + numDecodings(memo, s.substring(0,n-1));
        }
        
        // if the last two digit is less than 26. With Java, Integer.parseInt(twoDigitString) will treat "0x" as a real number.
        if (s.charAt(n-2) == '1' || (s.charAt(n-2) == '2' && s.charAt(n-1) <= '6')) {
            numOfWays = numOfWays + numDecodings(memo, s.substring(0,n-2));
        }
        
        memo[n] = numOfWays;     
        return memo[n]; 
    }
}
