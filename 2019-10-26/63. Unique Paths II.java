class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] ways = new int[m][n];

        //注意这个，不是先把第一行和第一列全赋值为1了，也不是只有有障碍的部分才是0，而是有障碍的位置之后都是0
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) ways[i][0] = 1;
            else break;
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) ways[0][i] = 1;
            else break;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    ways[i][j] = ways[i-1][j] + ways[i][j-1];
                }
            }
        }
        return ways[m-1][n-1];
    }
}
