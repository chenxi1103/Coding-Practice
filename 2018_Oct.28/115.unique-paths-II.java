public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     * 114.unique-paths那道题的followup，内部出现了obstacle
     * 重点是，如果第一行或者第一列出现了obstacle，不要在for循环里再set为0继续循环了，因为
     * 机器人只能往右或者往下走，如果第一行或者第一列就出现了障碍，机器人就不会再走障碍下方或者障碍右方
     * 的部分了，直接break！！！
     * 需要再复习！一定要把图论题和动态规划搞懂！
     * oct-28-6:23pm
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null||obstacleGrid.length == 0
        || obstacleGrid[0] == null || obstacleGrid[0].length == 0) return 0;
        final int row = obstacleGrid.length;
        final int col = obstacleGrid[0].length;
        int[][] sum = new int[row][col];
        for(int i = 0; i<row; i++){
            if(obstacleGrid[i][0]!=1){
                sum[i][0] = 1;
            }else{
                break;
            }
        }
        for(int j = 0; j<col; j++){
            if(obstacleGrid[0][j] != 1){
                sum[0][j] = 1;
            }else{
                break;
            }
        }
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                if(obstacleGrid[i][j] == 1){
                    sum[i][j] = 0;
                }else{
                    sum[i][j] = sum[i-1][j]+sum[i][j-1];
                }
            }
        }
        return sum[row-1][col-1];
    }
}
