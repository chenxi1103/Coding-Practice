class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] record = new int[row][col];
        record[0][0] = grid[0][0];
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) {
                    record[0][j] = grid[0][j] + record[0][j-1];
                }
                else if (j == 0) {
                    record[i][0] = grid[i][0] + record[i-1][0];
                } else {
                    record[i][j] = grid[i][j] + Math.min(record[i-1][j], record[i][j-1]);
                }
            }
        }
        return record[row-1][col-1];
   
