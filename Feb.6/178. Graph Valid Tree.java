public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(n != edges.length + 1) return false;
        List[] connection = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            connection[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edges.length; i++) {
            int[] curr = edges[i];
            connection[curr[0]].add(curr[1]);
            connection[curr[1]].add(curr[0]);
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            List list = connection[currNode];
            for(int i = 0; i < list.size(); i++) {
                int node = (int) list.get(i);
                if(set.contains(node)) continue;
                queue.offer(node);
                set.add(node);
            }
            count++;
        }
        return count == n;
    }
}
