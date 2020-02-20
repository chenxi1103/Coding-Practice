public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Set<UndirectedGraphNode> set = findAllNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for(UndirectedGraphNode n : set) {
            map.put(n, new UndirectedGraphNode(n.label));
        }
        for(UndirectedGraphNode key : map.keySet()) {
            UndirectedGraphNode curr = map.get(key);
            for(UndirectedGraphNode neighbor : key.neighbors) {
                curr.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    private Set<UndirectedGraphNode> findAllNodes(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode currNode = queue.poll();
            for(UndirectedGraphNode neighbor : currNode.neighbors) {
                if(!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return set;
    }
}
