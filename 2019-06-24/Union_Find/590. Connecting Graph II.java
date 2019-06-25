// Connecting Graph的变种，把query变成了求某个点有多少个点相连
// 其实就是for循环一下所有点，和这个点有相同大boss的就肯定是相连的
public class ConnectingGraph2 {
    private int[] parent;
    /*
    * @param n: An integer
    */public ConnectingGraph2(int n) {
        // do intialization if necessary
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);
        if (aRoot != bRoot) {
            parent[aRoot] = bRoot;
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        int result = 0;
        int root_a = findRoot(a);
        for (int i = 1; i < parent.length; i++) {
            int root_b = findRoot(i);
            if (root_a == root_b) result++;
        }
        return result;
    }

    private int findRoot(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findRoot(parent[a]);
    }
}
