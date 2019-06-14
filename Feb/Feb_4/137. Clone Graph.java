public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        // write your code here
        if(node == null) return node;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode> set = getAllNodes(node);
        for(UndirectedGraphNode currNode : set) {
            map.put(currNode, new UndirectedGraphNode(currNode.label));
        }
        for(UndirectedGraphNode key : map.keySet()) {
            UndirectedGraphNode currNode = map.get(key);
            for(UndirectedGraphNode neighbor : key.neighbors) {
                currNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    private Set<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                UndirectedGraphNode currNode = queue.poll();
                for(UndirectedGraphNode neighbor : currNode.neighbors) {
                    if(!set.contains(neighbor)) {
                        set.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return set;
    }
}
