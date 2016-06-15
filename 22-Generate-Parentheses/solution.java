/*
Create a new list
1st parenthesis
( // Accepted
) // NOT acceptable

Add 2nd parenthesis to the 1st, 
(( // Accepted
() // Accepted

Add 3rd parenthesis to the previous two.
(() // Accepted
((( // Accepted
()( // Accepted
()) // NOT acceptable

Termination condition
()()() rightCount == leftCount == n


What's the rule to determine if adding a left or right parenthesis is acceptable? 
"(": It's always okay to add a left parenthesis (as long as it is less than n) because the input is in pairs. 
")": Only if number of left parenthesis (leftCount) is greater than right parenthesis.
     In other words, add a ")" such that leftCount > rightCount

*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        // only initiate one arraylist so we don't have to create multiple lists. 
        ArrayList<String> res = new ArrayList<String>();
        
        generateParenthese(res, n, 0, 0, "");
        return res;
    }
    
    // the last parameter, why StringBuffer s does not work? Mutable VS Immutable String
    public List<String> generateParenthese(ArrayList<String> res, int n, int leftCount, int rightCount, String s) {
        
        // termination condition
        if (leftCount == n && rightCount == n ) 
            res.add(s);

        // Recursively add "(" or ")"
        if (leftCount < n )
            // left parenthesis add anytime as it does not break the matching syntax.
            generateParenthese(res, n, leftCount+1, rightCount, s+"(");
      
        // acceptable criteria for adding ")"
        if (rightCount < leftCount) {
            generateParenthese(res, n, leftCount, rightCount+1, s+")");
        }
        
        return res;
    }
}