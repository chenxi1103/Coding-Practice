class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public final int[] x_dir = {1,-1,0,0};
    public final int[] y_dir = {0,0,-1,1};

    public int zombie(int[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Queue<Point> queue = new LinkedList<>();
        int human = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1) queue.offer(new Point(i, j));
                if(grid[i][j] == 0){
                    if(isSafe(grid, i, j)) return -1;
                    human++;
                }
            }
        }
        if(human == 0) return 0;
        int days = 1;
        while(human != 0){
            while(!queue.isEmpty()){
                Point Zombie = queue.poll();
                for(int i = 0; i<4; i++){
                    int newX = Zombie.x+x_dir[i];
                    int newY = Zombie.y+y_dir[i];
                    if(isValidPoint(grid,newX, newY)){
                        if(grid[newX][newY] == 0){
                            human--;
                            if(human == 0) return days;
                            grid[newX][newY] = 1;
                        }
                    }
                }
            }
            days++;
            for(int i = 0; i<grid.length; i++){
                for(int j = 0; j<grid[0].length; j++){
                    if(grid[i][j] == 1) queue.offer(new Point(i,j));
                }
            }
        }
        return days;
    }



    private boolean isValidPoint(int[][] grid, int x, int y){
        return (x>=0 && x<grid.length && y>=0 && y<grid[0].length);
    }


    private boolean isSafe(int[][] grid, int x, int y){
        for(int i = 0; i<4; i++){
            int newX = x+x_dir[i];
            int newY = y+y_dir[i];
            if(isValidPoint(grid,newX, newY)){
                if(grid[newX][newY] != 2) return false;
            }
        }
        return true;
    }
}
