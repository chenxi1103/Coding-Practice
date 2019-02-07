/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // write your code here
        if(graph == null || graph.size() == 0) return null;
        if(values.get(node) == target) return node;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode currNode = queue.poll();
            for(UndirectedGraphNode neighbor : currNode.neighbors) {
                if(set.contains(neighbor)) continue;
                if(values.get(neighbor) == target) return neighbor;
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return null;
    }
}
