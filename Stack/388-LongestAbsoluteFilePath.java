public class Solution {
    public int lengthLongestPath(String input) {
        
        /*
        dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext
        
        dir
        \n\tsubdir1
        \n\t\tfile1.ext
        \n\t\tsubsubdir1
        \n\tsubdir2
        \n\nsubsubdir2
        \t\t\tfile2.ext
        
        */
        
        
        String[] tokens = input.split("\n");
        int max_len = 0; 
        int cur_len = 0; 
        Stack<Integer> stack = new Stack<Integer>(); // store the length of strings at every layer. 
        
        for (String token:tokens) {
            // count how many "\t"
            int level = countTab(token);
            String s = token.replaceAll("\t", ""); 
            
            // Current level is lower than elements in the stack, it needs to go to the upper level, pop from the stack until it reaches up to the target level. 
            while(level < stack.size()) 
                cur_len = cur_len - stack.pop();

            
            // if goes deeper level
            // when this is a file, add up all lengths, if not, add the length 
            if (s.contains(".")) {
                max_len = Math.max(max_len, cur_len + s.length());
            }
            else {
                stack.push(s.length()+1); // add the current non-file (dir) into the stack and plus a slash
                cur_len = cur_len + s.length()+1;  // update the total sum of cur_len in the stack, plus a slash
            }
        }
        
        return max_len; 
    }
    
    public int countTab(String token) {
        String temp = token.replaceAll("\t", "");   // tab is only one character
        return token.length() - temp.length(); 
    }
    
}
