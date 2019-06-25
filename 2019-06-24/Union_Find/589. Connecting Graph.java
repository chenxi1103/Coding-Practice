//图中点相连接的问题其实就是并查集的问题
//如果让你在一个图中查某两个点有没有直接或者间接相连，就是并查集问题！
//本题的findRoot，query，和connect就是模版，记住！
public class ConnectingGraph {
    private int[] father;
    /*
    * @param n: An integer
    */
    public ConnectingGraph(int n) {
        // do intialization if necessary
        father = new int[n+1];
        for (int i = 1; i < n; i++) {
            father[i] = i;
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
            // Only connect the boss node
            father[aRoot] = bRoot;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);
        return aRoot == bRoot;
    }

    private int findRoot(int a) {
        if (father[a] == a) return a;
        return father[a] = findRoot(father[a]);
    }
}
