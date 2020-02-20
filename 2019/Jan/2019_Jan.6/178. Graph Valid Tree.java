//判断是不是树的关键是：有没有环，这个只是让判断是不是树，而不是，是不是二叉树，所以只要图中没环且全连通，则符合条件
//全连通的条件是： 遍历整个图（用hashset遍历防止重复遍历某个点），set的size正好等于n，如果小于n，则没有全连通，大于n，则有环。
//小窍门： 如果图是树，那表示连通关系的edges的大小一定等于n-1（n个点无环全连通共有n-1个边），所以可以先判断edges的length，不等于n-1直接return false！
public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(n != edges.length + 1) return false;
        List[] neighbors = new ArrayList[n];
        for(int i = 0; i<n; i++){
            neighbors[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<edges.length; i++){
            neighbors[edges[i][0]].add(edges[i][1]);
            neighbors[edges[i][1]].add(edges[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            List neighbor = neighbors[node];
            for(int i = 0; i<neighbor.size(); i++){
                if(!set.contains((int)neighbor.get(i))){
                    set.add((int)neighbor.get(i));
                    queue.offer((int)neighbor.get(i));
                }
            }
        }
        return set.size() == n;
    }
}
