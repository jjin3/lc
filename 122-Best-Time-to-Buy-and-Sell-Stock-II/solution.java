// love this problem. STOCK and MONEY!
// find the increasing sequence and record the difference between the minimum and maxium. 
// example1: [2,1,3,7,9,6,5,1]  Tricky test case: This is a very good test case, decreasing at the end. 
// example2: [1,3,7,9,6,5,10,15]  This is a very good test case, increasing at the end. 

// 2ms run time. Very good!


public class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int sum = 0;
        int i = 0;
        while (i<prices.length-1) {
            while (i<prices.length-1 && prices[i] >= prices[i+1])  // in decreasing order
                i++;
            buy = i; // low point
            i++;
            while (i<prices.length-1 && prices[i+1] >= prices[i])  // in increasing order
                i++; 
            if (i<prices.length)  
                sell = i; 
                
            if (sell > buy)  //If statement needed for this test case: [2,1,3,7,9,6,5,1]
                sum = sum + (prices[sell]-prices[buy]);
            i++;
        }
        return sum; 
    }
}

// draw a diagram. 