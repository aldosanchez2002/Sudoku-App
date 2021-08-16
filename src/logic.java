public class logic {
    /*
        {
        {7, 0, 2, 0, 5, 0, 6, 0, 0},   r=1 c=4 c=3(c/3) r-=r%3
        {0, 0, 0, 0, '0', 3, 0, 0, 0},
        {1, 0, 0, 0, 0, 9, 5, 0, 0},
        {8, 0, 0, 0, 0, 0, 0, 9, 0},
        {0, 4, 3, 0, 0, 0, 7, 5, 0},
        {0, 9, 0, 0, 0, 0, 0, 0, 8},
        {0, 0, 9, 7, 0, 0, 0, 0, 5},
        {0, 0, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 7, 0, 4, 0, 2, 0, 3}
        }
    */
    int[][] Solver(int[][] input){

    }

    boolean isValidNumber(int[][] input, int test, int row, int column){
        //check if int is valid
        if(test>9 || test<1)return false;
        //check column
        for(int[] i : input){
            if (i[column] == test) return false;}
        //check row
        for(int i : input[row]){
            if (i == test) return false;}
        //check 3x3 square start top left
        row -= row%3;
        column-=column%3;
        for(int r=row; r < row+3;r++){
            for(int c=column; c <column+3;c++){
                if(input[r][c]==test)return false; } }
        return true;
    }


    boolean solvable(int[][] board) {
        // loops through puzzle looking for 0s
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == 0) {
                    // check numbers 1-9
                    for (int numberToTry = 1; numberToTry <= 9; numberToTry++) {
                        if (isValidNumber(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;
                            //RECURSION
                            if (solvable(board)) {
                                return true;
                            }
                            //set to 0
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    // no solution
                    return false;
                }
            }
        }
        //no 0s left
        return true;
    }

}