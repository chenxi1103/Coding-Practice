public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        int[] dirX = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] dirY = new int[]{2, -2, 2, -2, 1, -1, 1, -1};
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        if(!isValidPoint(grid, source) || !isValidPoint(grid, destination)) return -1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        grid[source.x][source.y] = true;
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                Point curr = queue.poll();
                for(int i = 0; i < 8; i++) {
                    int newX = curr.x + dirX[i];
                    int newY = curr.y + dirY[i];
                    Point currP = new Point(newX, newY);
                    if(!isValidPoint(grid, currP) || grid[currP.x][currP.y]) continue;

                    if(newX == destination.x && newY == destination.y) {
                        steps++;
                        return steps;
                    }
                    grid[currP.x][currP.y] = true;
                    queue.offer(currP);
                }
            }
            steps++;
        }
        return -1;
    }
    private boolean isValidPoint(boolean[][] grid, Point point) {
        if(point.x < 0 || point.x >= grid.length || point.y <0 || point.y >= grid[0].length) return false;
        return !grid[point.x][point.y];
    }
}
