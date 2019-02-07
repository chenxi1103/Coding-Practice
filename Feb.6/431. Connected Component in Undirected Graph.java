public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        for(int i = 0; i < nodes.size(); i++) {
            if(set.contains(nodes.get(i))) continue;
            queue.offer(nodes.get(i));
            set.add(nodes.get(i));
            List<Integer> sublist = new ArrayList<>();
            while(!queue.isEmpty()) {
                UndirectedGraphNode node = queue.poll();
                sublist.add(node.label);
                for(UndirectedGraphNode neighbor : node.neighbors) {
                    if(set.contains(neighbor)) continue;
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            Collections.sort(sublist);
            list.add(sublist);
        }
        return list;
    }
}
