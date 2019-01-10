public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int x_dir[] = {1, 1, -1, -1, 2, 2, -2, -2};
        int y_dir[] = {2, -2, 2, -2, 1, -1, 1, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        grid[source.x][source.y] = true;
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                Point curr_point = queue.poll();
                if(curr_point.x == destination.x && curr_point.y == destination.y) return steps;
                for(int i = 0; i < 8; i++){
                    int newX = curr_point.x + x_dir[i];
                    int newY = curr_point.y + y_dir[i];
                    if(isValidPoint(grid, newX, newY)) {
                        queue.offer(new Point(newX, newY));
                        grid[newX][newY] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private boolean isValidPoint(boolean[][] grid, int x, int y){
        if(x < 0 || x > grid.length - 1) return false;
        if(y < 0 || y > grid[0].length - 1) return false;
        return !grid[x][y];
    }
}
