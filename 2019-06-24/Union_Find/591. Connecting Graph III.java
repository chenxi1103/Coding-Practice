//这道题query变成求有多少相连的component，这个有一个小技巧
//就是每当两个点connect了，那总相连的component肯定要减一，因为原来是两个component
//连在一起变成了一个合并的component！

public class ConnectingGraph3 {
    private int[] parent;
    private int count;
    public ConnectingGraph3(int n) {
        parent = new int[n + 1];
        count = n;
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
    }
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int root_a = findRoot(a);
        int root_b = findRoot(b);
        if (root_a != root_b) {
            parent[root_a] = root_b;
            count--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return count;
    }

    private int findRoot(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = findRoot(parent[a]);
    }
}
