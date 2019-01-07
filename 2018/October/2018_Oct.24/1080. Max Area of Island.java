public class Solution {
    /**
     * @param grid: a 2D array
     * @return: the maximum area of an island in the given 2D array
     * 图论题，注意bfs和递归的运用
     * 日期：2018-10-24
     */
    public int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length==0 || grid[0] == null|| grid[0].length == 0) return 0;
        int max = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(grid,i,j,0));
                }
            }
        }
        return max;
    }
    public int dfs(int[][]grid, int i,int j,int count){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0) return 0;
        if(grid[i][j] == 1){
            grid[i][j] = 0;
            count = 0;
            for(int[] dir : dirs){
                    int newX = i+dir[0];
                    int newY = j+dir[1];
                    count += dfs(grid, newX, newY, count);
            }
        }
        return count+1;
    }
}