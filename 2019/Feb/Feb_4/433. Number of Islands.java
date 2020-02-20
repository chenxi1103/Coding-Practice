public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        // write your code here
        int[] dirX = new int[]{0,0,1,-1};
        int[] dirY = new int[]{1,-1,0,0};
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int counter = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]) {
                    counter++;
                    Queue<Point> queue = new LinkedList<>();
                    Point curr = new Point(i, j);
                    queue.offer(curr);
                    grid[curr.x][curr.y] = false;

                    while(!queue.isEmpty()){
                        Point currPoint = queue.poll();
                        for(int k = 0; k < 4; k++) {
                            int newX = currPoint.x + dirX[k];
                            int newY = currPoint.y + dirY[k];
                            if(isValidPoint(grid, newX, newY)) {
                                Point valid = new Point(newX, newY);
                                queue.offer(valid);
                                grid[newX][newY] = false;
                            }
                        }
                    }
                }
            }
        }
        return counter;
    }

    private boolean isValidPoint(boolean[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
        return grid[i][j];
    }
}
