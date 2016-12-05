public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        // scan the array and find the positions of word1 and word2
        // before we find positions of pos1 and pos2, they will stay with a negative value. Let pos1 and pos2 start with "-1"
        // Once we find the positions, calcualte the distances and update min_distance, and min should be an abstract value; 
        // My solution also handles the corner case when word1 or word2 might not be in the list 

        int pos1=-1, pos2=-1; 
        int min_distance=Integer.MAX_VALUE; 
        int i=0;
        
        for (i=0; i<words.length; i++) {
            
            if (words[i].equals(word1))
                pos1=i;
            if (words[i].equals(word2))
                pos2=i; 
            
            if(pos1!=-1 && pos2!=-1)
                min_distance = Integer.min(min_distance, Math.abs(pos1-pos2));  
        }
        
        if(i==words.length && (pos1==-1 || pos2==-1)) // an extension, what if one string doesn't exist. 
            return -1; 
        return min_distance; 
    }
}
