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
    int row,col;
    int [] directionX = {1,1,-1,-1,2,2,-2,-2};
    int [] directionY = {2,-2,2,-2,1,-1,1,-1};
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if(grid == null||grid.length == 0|| grid[0].length == 0) return -1;
        row = grid.length;
        col = grid[0].length;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(source);
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size;++i){
                Point currPoint = queue.poll();
                if(currPoint.x == destination.x && currPoint.y == destination.y){
                    return steps;
                }
                for(int j = 0; j<8;++j){
                    Point nextPoint = new Point(
                        currPoint.x+directionX[j],
                        currPoint.y+directionY[j]
                        );
                    if(!inBound(grid,nextPoint)){
                        continue;
                    }
                    queue.offer(nextPoint);
                    grid[nextPoint.x][nextPoint.y] = true;
                }
            }
            steps++;
        }
        return -1;
    }
    private boolean inBound(boolean[][] grid, Point point){
        if(point.x<0||point.x>=grid.length||point.y<0||point.y>=grid[0].length){
            return false;
        }
        return (grid[point.x][point.y] == false);
    }
}
