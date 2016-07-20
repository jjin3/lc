public class Solution {
    
    //Given [1,1,1,2,2,3] and k = 2, return [1,2]. There are k=2 (2 numbers) that have the highest frequency among all. 
    // when frequency >= k, add this number to the result list. 
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        
        // one pass on nums[] array
        for (Integer n:nums) {
            if (!freqMap.containsKey(n))
                freqMap.put(n,1);
            else {
                freqMap.put(n,freqMap.get(n)+1);
            }
        }
        // Build res array
        ArrayList<Integer> res = new ArrayList<Integer>();

//[1,1,1,2,2,3,3] and k = 2
// (1,3) (2,2) (3,2)
// Priority queue

        // second pass on hashmap and add element to priority queue
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(freqMap.entrySet());
    
        for(int i = 0; i < k; i++){
            res.add(pq.poll().getKey());
        }
        return res;
        
    }
}