public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        // write your code here
        int[] Dir_X = new int[]{-1, 1, 0, 0};
        int[] Dir_Y = new int[]{0, 0, -1, 1};
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));
                    grid[i][j] = false;
                    while (!queue.isEmpty()) {
                        Point currPoint = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int new_x = currPoint.x + Dir_X[k];
                            int new_y = currPoint.y + Dir_Y[k];
                            if (isValidPoint(new_x, new_y, grid) && grid[new_x][new_y]) {
                                queue.add(new Point(new_x, new_y));
                                grid[new_x][new_y] = false;
                            }
                        }
                    }
                    counter++;
                }
            }
        }
        return counter;
    }
    private boolean isValidPoint(int x, int y, boolean[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
