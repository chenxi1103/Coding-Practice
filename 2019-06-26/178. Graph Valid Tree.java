// 第一次如此直观得感受到了并查集的方便和强大。。。
// 比普通的用bfs的解法解少了2，30行代码，还快了不少，真的很方便，而且理解起来容易太多了
// 可以参考number of island的union find的解法。
// 在UnionFind class定义一个count的field记录当前有多少个“小岛”，如果是一个graph tree的话最后应该有且仅有一个“小岛”。
// 成环情况可通过edges.length != n - 1来判断，有没有连在树上的点可以通过count ！= 1来判断。

class UnionFind {
    int[] parent;
    int count;
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void connect (int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
            count--;
        }
    }

    public int find (int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

}

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (edges.length != n - 1) return false;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            unionFind.connect(edges[i][0], edges[i][1]);
        }
        return unionFind.count == 1;
    }
}
