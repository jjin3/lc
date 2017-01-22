public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        /* 
        1, 3, 5, 7, 9, 20, 30, 40, 50

        */
        
        if (A==null || A.length <= 2) return 0; 
        
        
        int sum = 0; 
        int diff = 0; 
        int length = 2;
        
        // find all longest subsequences
        for (int i=1; i<A.length; i++) {
            if ((A[i]-A[i-1]) == diff) {
                length++; 
            }
            else {
                 // find the length of longest subsequences and find the num of slices out of each subsequences
                if (length >=3 ) {
                    // sum up all subsequences
                    int numOfSlices = findNumOfSlicesSubSequeces(length); 
                    sum += numOfSlices; 
                }
                length = 2; 
                diff = A[i]-A[i-1]; 
            }
        }
        // the last diff
        
        if (length>=3 && diff == 0) sum += findNumOfSlicesSubSequeces(length-1);
        else if (length>=3) sum += findNumOfSlicesSubSequeces(length);
        
        return sum; 
    }
    
    public int findNumOfSlicesSubSequeces(int length) {
        int numOfSlices = 0;
        int subLen = 3; 
        for (int i=subLen; i<=length; i++) {
            // if length = 5; 1: 3; 2: 5; 3:6
            // 4-3+1=2
            numOfSlices += length - i + 1;  
        }
        return numOfSlices;
    }
}
