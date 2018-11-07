public class Solution {
    /**
     * @param board: the board
     * @return: whether the Sudoku is valid
     * 有毒，还是一个一个check，非常想一起check了，貌似没有这样的答案……
     */
    public boolean isValidSudoku(char[][] board) {
        // write your code here
        final int row = board.length;
        final int col = board[0].length;
        if(row!=col || row!=9 || col!=9) return false;
        for(int i = 0; i<9; i++){
            int[] check = new int[9];
            for(int j = 0; j<9; j++){
                int curr = board[i][j] - '1';
                if(curr>0 && curr<10){
                    check[curr]++;
                    if(check[curr]>1) return false;
                }
            }
        }
        for(int i = 0; i<9; i++){
            int[] check = new int[9];
            for(int j = 0; j<9; j++){
                int curr = board[j][i] - '1';
                if(curr>0 && curr<10){
                    check[curr]++;
                    if(check[curr]>1) return false;
                }
            }
        }
        for(int i = 0; i<9; i+=3){
            for(int j = 0; j<9; j+=3){
                int[] check = new int[9];
                for(int k = 0; k<9; k++){
                    int curr = board[i+k/3][j+k%3] - '1';
                    if(curr>0 && curr<10){
                        check[curr]++;
                        if(check[curr]>1) return false;
                    }
                }
            }
        }
        return true;
    }
}
