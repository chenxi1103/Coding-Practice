//自己想出来的dp，真棒，继续加油！
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        if(obstacleGrid[0][0] == 1) return 0;
        if(obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            return 1;
        }
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++) {
            for(int j = 0; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1) {
                    memo[i][j] = 0;
                    continue;
                }
                if((i == 1 && j == 0) || (i == 0 && j ==1)) {
                    memo[i][j] = 1;
                    continue;
                }
                if(isValidPoint(obstacleGrid, i-1, j)) {
                    memo[i][j] += memo[i-1][j];
                }
                if(isValidPoint(obstacleGrid, i, j-1)) {
                    memo[i][j] += memo[i][j-1];
                }
            }
        }
        return memo[obstacleGrid.length -1][obstacleGrid[0].length - 1];
    }
    private boolean isValidPoint(int[][] obstacleGrid, int i, int j) {
        return i >=0 && i < obstacleGrid.length && j >= 0 && j < obstacleGrid[0].length;
    }
}
