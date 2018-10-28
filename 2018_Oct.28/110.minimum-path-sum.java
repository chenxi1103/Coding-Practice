public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     * 一到图论题但是没有用到dfs或者bfs，其思路是，先算出第一行和第一列的加和值，然后内部的
     * 值是取上侧或者是左侧的较小值进行加和，因为是从左上往右下走，所以走下一步的时候只有可能是从
     * 当前位置的上方或者当前位置的左方走过来的，所以取上方或左方的较小值代表路径
     * 做的不熟，还需要再复习
     * oct-28-3:11pm
     */
    public int count = 0;
    public int minPathSum(int[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] sum = new int[row][col];
        sum[0][0] = grid[0][0];
        for(int i = 1; i<row; i++){
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        for(int i = 1; i<col; i++){
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1])+grid[i][j];
            }
        }
        return sum[row-1][col-1];
    }
}
