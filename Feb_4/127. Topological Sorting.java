public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for(int i = 0; i < graph.size(); i++) {
            map.put(graph.get(i), 0);
        }
        for(int i = 0; i < graph.size(); i++) {
            DirectedGraphNode node = graph.get(i);
            for(DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) + 1);
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        ArrayList<DirectedGraphNode> list = new ArrayList<>();
        for(int i = 0; i < graph.size(); i++) {
            if(map.get(graph.get(i)) == 0) {
                queue.offer(graph.get(i));
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                DirectedGraphNode node = queue.poll();
                list.add(node);
                for(DirectedGraphNode neighbor : node.neighbors) {
                    map.put(neighbor, map.get(neighbor) - 1);
                    if(map.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return list;
    }
}
