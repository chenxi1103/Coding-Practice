// 虽然一打开还是只会用bfs写，但是也要努力用并查集来解一下！
public class Solution {
    class UnionFind {
        private int[] parent;
        private int count;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() { return this.count;}

        public int find(int a) {
            if (parent[a] == a) return a;
            return parent[a] = find(parent[a]);
        }

        public void connect(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                parent[root_a] = root_b;
                this.count--;
            }
        }

    }
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        int result = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return result;
        int m = grid.length;
        int n = grid[0].length;
        final int[] DIR_X = {0, 0, 1, -1};
        final int[] DIR_Y = {1, -1, 0, 0};
        UnionFind unionFind = new UnionFind(m*n);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) count++;
            }
        }
        unionFind.setCount(count);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    for (int k = 0; k < DIR_X.length; k++) {
                        int x = i + DIR_X[k];
                        int y = j + DIR_Y[k];
                        if (validPoint(x, y, grid)) {
                            unionFind.connect(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        return unionFind.getCount();
    }

    private boolean validPoint(int x, int y, boolean[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y];
    }
}

//老朋友number of island，说是可以用并查集来做，可是打开这道题还是只会用bfs写噗
public class Solution {
    public class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        final int[] DIR_X = {0, 0, 1, -1};
        final int[] DIR_Y = {1, -1, 0, 0};
        int result = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return result;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    queue.add(new Point(i, j));
                    grid[i][j] = false;
                    while (queue.size() != 0) {
                        Point currentPoint = queue.poll();
                        for (int k = 0; k < DIR_X.length; k++) {
                            Point point = new Point(currentPoint.x + DIR_X[k], currentPoint.y + DIR_Y[k]);
                            if (validPoint(point.x, point.y, grid)) {
                                queue.add(point);
                                grid[point.x][point.y] = false;
                            }
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }

    private boolean validPoint(int x, int y, boolean[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y];
    }
}
