class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    public final int[] x_dir = {0,0,-1,1};
    public final int[] y_dir = {1,-1,0,0};
    public int shortestDistance(int[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    int sum_steps = bfs(grid, new Point(i, j));
                    result = Math.min(result, sum_steps);
                }
            }
        }
        if(result == Integer.MAX_VALUE) return -1;
        return result;
    }

    private int bfs(int[][] grid, Point postoffice){
        Queue<Point> queue = new LinkedList<>();
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        queue.offer(postoffice);
        marked[postoffice.x][postoffice.y] = true;
        int result = 0;
        int each = 0;
        while(!queue.isEmpty()){
            each++;
            int size = queue.size();
            for(int j = 0; j<size; j++){
                Point currPoint = queue.poll();
                for(int i = 0; i<4; i++){
                    int newX = currPoint.x + x_dir[i];
                    int newY = currPoint.y + y_dir[i];
                    Point step = new Point(newX, newY);
                    if(isValidPoint(grid, step) && !marked[newX][newY]){
                        marked[newX][newY] = true;
                        if( grid[newX][newY] == 0){
                            queue.offer(step);
                        }
                        if(grid[newX][newY] == 1){
                            result = result + each;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !marked[i][j]) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return result;
    }


    private boolean isValidPoint(int[][] grid, Point point){
        int x = point.x;
        int y = point.y;
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length);
    }
}
