/// This solution beats >90% of run time. 

public class Solution {
    
    public int firstUniqChar(String s) {
        
        int[] map = new int[26]; 
        char[] arr = s.toCharArray(); 
        
        for (char c:arr) {
            if(map[c-'a']==0)
                map[c-'a'] = 1; 
            else if (map[c-'a']>=1){
                map[c-'a'] = 2;
            }
        }
        
        for (int i=0; i<s.length(); i++) {
            if(map[arr[i]-'a']==1) return i;
        }
        return -1; 
    }
}
