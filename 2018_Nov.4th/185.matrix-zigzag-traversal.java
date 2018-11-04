public class Solution {
    /**
     * @param matrix: An array of integers
     * @return: An array of integers
     * 啊最苦手这种题了嘤嘤嘤，要学会找规律，规律是，如果i+j是odd的话，就row++,col--，如果i=j是
     * 偶数的话就row--,col--，在++，--的时候注意保证++不要越界，--不要小于0就好
     * 需要复习！
     * nov4th-11:44am
     */
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        final int row = matrix.length;
        final int col = matrix[0].length;
        int[] result = new int[row*col];
        int i = 0, j = 0;
        int counter = 0;
        for(int s = 0; s<=row+col-2; s++){
            if(s%2!=0){
                for(j = Math.min(s, col-1), i = s-j; j>=0&&i<row; j--,i++){
                    result[counter++] = matrix[i][j];
                }
            }else{
                for(i = Math.min(s,row-1), j = s-i; i>=0&&j<col; i--, j++){
                    result[counter++] = matrix[i][j];
                }
            }
        }
        return result;
    }
}
