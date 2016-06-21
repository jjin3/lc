/*
To find the right pattern, it's very important to derive nth solution from n=1, and n=2, n=3 etc.
n=1: 0  1

n=2: 0  1  11  10   

n=3: 0    1  11  10 (not changed, theoretically think of it as adding a "0" to the begining of the list, and add '1' from n=2 list in reverse order to create the second part of the sequence, which is  (1)10   (1)11   (1)01   (1)00

n=4: 0    1  11  10  110  111  101  100   (not changed, and add '1' from n=3 list in reverse order to create the second part of the sequence, which is  (1)100  (1)101  (1)111  (1)110  (1)010  (1)011  (1)001  (1)000
*/


public class Solution {
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    public List<Integer> grayCode(int n) {
           
        if (n==0) {
            list.add(0);   
            return list;   
        }   
         
        if (n==1) {
            list.add(0);
            list.add(1);
            return list;
        }
     
        list = (ArrayList) grayCode(n-1);
        
        for (int i=list.size() - 1; i>=0; i--) {
            list.add(list.get(i) + (1 << (n-1)));  // to add an "1" at the very begin of every integer in the list. 
        }
        
        return list;    
    }
}