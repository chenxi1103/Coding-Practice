public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
     
    /**what is a valid tree?
     * 1. There is no circle in the graph EQUALS edges.length == n-1
     * 2. Every point has its connection EQUALS the number of points we visited equals n
     * */
     
    public boolean validTree(int n, int[][] edges) {
        if(edges == null) return false;
        if(edges.length != n-1) return false;
        HashMap<Integer,HashSet<Integer>> map = new HashMap<Integer,HashSet<Integer>>();
        for(int i = 0; i<n; i++){
            map.put(i,new HashSet<Integer>());
        }
        for(int i = 0; i<edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        
        Set<Integer> set = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.offer(0);
        set.add(0);
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int nums : map.get(num)){
                if(set.contains(nums)) continue;
                queue.offer(nums);
                set.add(nums);
            }
        }
        return set.size() == n;
    }
}
