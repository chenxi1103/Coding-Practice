class coordinate {
    int x,y;
    public coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if(grid == null || grid.length == 0||grid[0].length == 0) return 0;
        int island = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]){
                    BFSisland(grid,i,j);
                    island++;
                }
            }
        }
        return island;
    }
    private void BFSisland(boolean[][] grid, int x, int y){
        int[] X = {1,0,0,-1};
        int[] Y = {0,1,-1,0};
        Queue<coordinate> queue = new LinkedList<>();
        queue.offer(new coordinate(x,y));
        grid[x][y] = false;
        while(!queue.isEmpty()){
            coordinate coor = queue.poll();
            for(int i = 0; i<4; i++){
                coordinate temp = new coordinate(coor.x+X[i],coor.y+Y[i]);
                if(!inBound(grid,temp)) continue;
                if(grid[temp.x][temp.y]){
                   grid[temp.x][temp.y] = false;
                   queue.offer(temp);
                }
            }
        }
    }
    private boolean inBound(boolean[][]grid, coordinate temp){
        return temp.x >= 0 && temp.x < grid.length && temp.y >= 0 && temp.y < grid[0].length;
    }
}
