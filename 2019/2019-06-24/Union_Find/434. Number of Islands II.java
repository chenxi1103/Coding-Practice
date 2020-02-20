// number of island II，这道题就更适合用并查集而不是bfs了
// 因为bfs需要每次把整个图都过一遍，但是并查集就不需要，只需要在当前点进行操作就好了
// 记得考虑operations可能会有重复点，要先判断一下这个点之前算过没有。

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
    class UnionFind {
        private int[] parent;
        public int count;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int query() { return count;}

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
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (operators == null || operators.length == 0) return list;
        boolean[][] map = new boolean[n][m];
        UnionFind unionFind = new UnionFind(n * m);
        for (int i = 0; i < operators.length; i++) {
            int x = operators[i].x;
            int y = operators[i].y;
            if (!map[x][y]) {
                unionFind.count++;
                map[x][y] = true;
                if (x - 1 >= 0 && map[x-1][y]) {
                    unionFind.connect(x*m + y, (x-1)*m + y);
                }
                if (x + 1 < n && map[x+1][y]) {
                    unionFind.connect(x*m + y, (x+1)*m + y);
                }
                if (y - 1 >= 0 && map[x][y-1]) {
                    unionFind.connect(x*m + y, x*m + y - 1);
                }
                if (y + 1 < m && map[x][y+1]) {
                    unionFind.connect(x*m + y, x*m + y + 1);
                }
            }
            list.add(unionFind.query());
        }
        return list;
    }
}
