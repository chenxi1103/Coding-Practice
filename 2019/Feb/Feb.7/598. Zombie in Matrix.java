public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    final static int[] dir_x = new int[]{0, 0, -1, 1};
    final static int[] dir_y = new int[]{-1, 1, 0, 0};
    public int zombie(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Queue<Point> queue = new LinkedList<Point>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int thisPoint = grid[i][j];
                if(thisPoint == 0 && !canBeEat(grid, i, j)) return -1;
                if(thisPoint == 1) {
                    Point point = new Point(i, j);
                    queue.offer(point);
                }
            }
        }
        int day = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point currPoint = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int new_x = currPoint.x + dir_x[j];
                    int new_y = currPoint.y + dir_y[j];
                    if(isValidPoint(grid, new_x, new_y) && grid[new_x][new_y] == 0) {
                        grid[new_x][new_y] = 1;
                        Point newPoint = new Point(new_x, new_y);
                        queue.offer(newPoint);
                    }
                }
            }
            day++;
        }
        //这一点很重要，要返回day - 1，因为最后一天僵尸不会感染人，而是确保没有什么多余的人可以感染了，然后queue就空了，所以-1。
        return day - 1;
    }
    private boolean isValidPoint(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
        return true;
    }
    private boolean canBeEat(int[][] grid, int x, int y) {
        for(int i = 0; i < 4; i++) {
            int new_x = x + dir_x[i];
            int new_y = y + dir_y[i];
            if (isValidPoint(grid, new_x, new_y) && grid[new_x][new_y] != 2) return true;
        }
        return false;
    }
}
