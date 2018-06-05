class point{
    int x, y;
    public point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int[] directionX = {-1,1,0,0};
    public int[] directionY = {0,0,-1,1};
    public int zombie(int[][] grid) {
        //Special case
        if(grid == null||grid.length == 0|| grid[0].length == 0) return 0;
        
        Queue<point> queue = new LinkedList<point>();
        int people = 0;
        for(int i = 0; i<grid.length;i++){
            for(int j =0; j<grid[0].length;j++){
                if(grid[i][j] == 0) people++;
                else if(grid[i][j] == 1){
                    queue.offer(new point(i,j));
                }
            }
        }
        
        //Special case
        if(people == 0) return 0;
        
        int day = 0;
        while(!queue.isEmpty()){
            day++;
            int size = queue.size();
            for(int i = 0; i<size; i++){
                //We can poll the zombie out, since if they have already turned their nearest people into zombie, they have no use anymore. They cannot move! So we can pull them out!
                point currPoint = queue.poll();
                for(int j = 0; j<4; j++){
                    point nextPoint = new point(currPoint.x+directionX[j],currPoint.y+directionY[j]);
                    //The point has to be in the grid and be the people at the same time
                    if(inBound(grid,nextPoint.x,nextPoint.y)&&grid[nextPoint.x][nextPoint.y] == 0){
                        grid[nextPoint.x][nextPoint.y] = 1;
                        people--;
                        if(people == 0) return day;
                        queue.offer(nextPoint);
                    }
                }
            }
        }
        return -1;
    }
    private boolean inBound(int[][] grid, int x, int y){
        return x>=0&&x<grid.length&&y>=0&&y<grid[0].length;
    }
}
