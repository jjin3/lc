public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int size = board.length; 
        boolean[][] rowchecker = new boolean[size][size];
        boolean[][] columnchecker = new boolean[size][size];
        boolean[][] boxchecker = new boolean[size][size];
        
        // check the possibility of filling a number into the board, not really fill a real number into a board. 
        
        for (int row=0; row<board.length; row++) {
            for (int col=0; col<board[row].length; col++) {
    
                if (board[row][col] != '.') { // got an number, which shouldn't appear elsewhere in the row, col or box
                    int number = board[row][col]  - '0'; 
                    // In the if statement: 
                    // check whether this number exists in this row, (if this number already exists, that means the same row has two same numbers)
                    
                    // check whether this number exists in this column. (if this number already exists, that means the same column has two same numbers)
                
                    // check whether this number exists in the square/box. (if this number already exists, that means the same box has two same numbers)
                    //  num - 1 for starting from zero index
                    
                    if (rowchecker[row][number-1] || columnchecker[col][number-1] || boxchecker[3*(row/3)+col/3][number-1]) { // mark it as exist at the row, or column, or box
                        return false; 
                    }
                    
                    // If all checks are good, mark all of them as unvailable from this point. 
                    rowchecker[row][number-1] = true;
                    columnchecker[col][number-1] = true;
                    boxchecker[3*(row/3)+col/3][number-1] = true;
            }
        }
    }
    return true; 
    }
}
