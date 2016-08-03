/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */


// Brute force approach hits Time Limit Exceeded when the integer is sufficiently large. 

// Binary search: This is an easy binary search question, the only variation from the original binary search is the guess(num) API. Where this API should be used in this problem? Essentially guess(int num) is a comparison method that compares the target which generated by leetcode platform, with the *mid* element. This means that the target value in "if (taregt == mid) or if (target < mid) and if (target > mid)"" pattern can be replaced by "target = guess(mid)". However, calling guess(mid) three times is very expensive, this will also trigger Time Limit Exceeded when n reaches 2G

// Note: This is a lazy bad habit "int mid = (low+high)/2" because it always trigger integer overflow. Always use "int mid = low + (high - low) / 2;"

public class Solution extends GuessGame {
    
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int guessResult = guess(mid);
            if (guessResult == 0) {
                return mid;
            }
            else if (guessResult == -1) {  // target number is lower, move to the first half.
                high = mid - 1;
            }
            else if (guessResult == 1) { // target number is higher, move to the second half. 
                low = mid + 1;
            }
        }
        return -1;
    }
    
}