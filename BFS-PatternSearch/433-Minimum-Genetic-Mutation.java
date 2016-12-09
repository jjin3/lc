public class Solution {
    
    private class GeneNode {
        String val; 
        int distance; 
        
        public GeneNode(String val, int distance) {
            this.val = val; 
            this.distance = distance; 
        }
    }

    public int minMutation(String start, String end, String[] bank) {
        
        LinkedList<GeneNode> queue = new LinkedList<GeneNode>();
        
        Set<String> bankset = new HashSet<String>();
        
        for (String str:bank) {
            bankset.add(str);
        }
        
        // Add start Node to the queue and add end to the gene bank set
        GeneNode startNode = new GeneNode(start, 0);
        queue.add(startNode);
        
        
        // bankset must not be empty
        // bankset must contains end string because end string must be a valid gene too. 
        if (bankset.isEmpty() || !bankset.contains(end)) return -1; 
        
        //bankset.add(end);
        
        while(!queue.isEmpty()) {

            GeneNode geneNode = queue.poll();       
            
            if (geneNode.val.equals(end)) {
                return geneNode.distance; 
            }
            
            search(queue, bankset, geneNode); 
        }
        return -1; 
    }
    
    public void search(Queue<GeneNode> queue, Set<String> bankset, GeneNode geneNode) {
        char[] validChar = {'A', 'C', 'G', 'T'};
        char[] vararr = geneNode.val.toCharArray(); 

        // search for one mutation
        for (int i=0; i<vararr.length; i++) {
            //"AACCGGTT"
            for (char validCh : validChar) {
                String s = geneNode.val.substring(0,i) + validCh + geneNode.val.substring(i+1); 
                if (bankset.contains(s)) {
                    queue.add(new GeneNode(s, geneNode.distance+1)); 
                    bankset.remove(s); // delete the selected mutation
                }             
            }
        }
    }
}
