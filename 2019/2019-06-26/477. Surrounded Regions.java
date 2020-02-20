// 这个是题利用的特性是，如果某个连片的小岛，有一块岛屿是在边界上的，拿它就一定没办法被包围
// 先把边界和一个独立的点相连（用这个点当父节点），然后遍历整个图，把点该连的连起来
// 最后查连起来的点有没有也和边界相连，没有相连就把它反转
class UnionFind {
    int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void connect (int a, int b) {
        int rootA = parent[a];
        int rootB = parent[b];
        if (rootA != rootB) {
            //这道题是要定义大小之分的！！！
            parent[Math.min(rootA, rootB)] = Math.max(rootA, rootB);
        }
    }

    public int find (int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        // write your code here
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        final int[] DIR_X = {0, 0, -1, 1};
        final int[] DIR_Y = {-1, 1, 0, 0};
        int edge = m*n;
        UnionFind unionFind = new UnionFind(edge + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        unionFind.connect(i*n + j, edge);
                    } else {
                        for (int k = 0; k < DIR_X.length; k++) {
                            int X = i + DIR_X[k];
                            int Y = j + DIR_Y[k];
                            if (board[X][Y] == 'O') {
                                unionFind.connect(i*n + j, X*n + Y);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (board[i][j] == 'O' && unionFind.find(i*n + j) != edge) board[i][j] = 'X';
            }
        }
    }
}
