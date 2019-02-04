//找最短路径的关键，在记数的时候，不是每走一步就要加一，而是没每走一层要加一。
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

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
        if(source.x < 0 || source.x >= grid.length || source.y < 0 ||source.y >= grid[0].length
        || destination.x < 0 || destination. x >= grid.length || destination.y < 0 || destination.y >= grid[0].length) return -1;
        int count = 0;
        int[] x_dir = {1,1,-1,-1,2,2,-2,-2};
        int[] y_dir = {2,-2,2,-2,1,-1,1,-1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                Point currPoint = queue.poll();
                if(currPoint.x == destination.x && currPoint.y == destination.y) return count;
                for(int j = 0; j<8; j++){
                    Point newPoint = new Point(currPoint.x + x_dir[j], currPoint.y + y_dir[j]);
                    if(newPoint.x >= 0 && newPoint.x < grid.length && newPoint.y >= 0 && newPoint.y < grid[0].length && grid[newPoint.x][newPoint.y] == false){
                        queue.offer(newPoint);
                        grid[newPoint.x][newPoint.y] = true;
                    }
                }
                count++;
            }
        }
        return -1;
    }
}
