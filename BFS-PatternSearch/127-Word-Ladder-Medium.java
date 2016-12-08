public class Solution {

    private class WordNode{
        String word;
        int distance;
    
        public WordNode(String word, int distance){
            this.word = word;
            this.distance = distance;
        }
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {

        WordNode startNode = new WordNode(beginWord, 1);
        
        Queue<WordNode> queue = new LinkedList<WordNode>(); 
        queue.add(startNode); // Add the first node to the queue. 

        wordDict.add(endWord); // add endNode to the word dictionary, if an endnode can be found later, return; 

        while(!queue.isEmpty()) {
            WordNode top = queue.poll();   // This equals to remove();
            String word = top.word; 

            if (word.equals(endWord)) {
                return top.distance; 
            }
            // if endWord hasn't been found. search for the valid word from dictionary 
            getValidWords(queue, top, wordDict); 

        }
        return 0; //if no path found. 
    }

    public void getValidWords(Queue<WordNode> queue, WordNode wordnode, Set<String> wordDict) {

        // construct a new word that might be included in the dictionary, Instead use char array. 
        /* String concatination is very slow. Don't do this:  String newWord = thisWord.substring(0,i) + c + thisWord.substring(i+1); 
        */

        char[] arr = wordnode.word.toCharArray(); 

        for(int i=0; i<arr.length; i++){
            for(char c='a'; c<='z'; c++){
                char temp = arr[i];
                if(arr[i]!=c){
                      arr[i]=c;
                }
 
                String newWord = new String(arr);
        
                // if a word is found, increament the distance, delete the word from Set<wordDict> 
                
                if (wordDict.contains(newWord)) {  // This searching from a Set takes O(1) time
                    queue.add(new WordNode(newWord, (wordnode.distance+1)));    
                    wordDict.remove(newWord);
                }
                arr[i]=temp;  // recover it once it's done. This is important!
            }
        }
    }
}
