/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nodes == null || nodes.size() == 0) return result;
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        int size = nodes.size();
        while(set.size() != size){
            queue.offer(nodes.get(0));
            set.add(nodes.get(0));
            ArrayList<Integer> list = new ArrayList<>();
            while(!queue.isEmpty()){
                UndirectedGraphNode node = queue.poll();
                nodes.remove(nodes.indexOf(node));
                list.add(node.label);
                for(UndirectedGraphNode neighbor : node.neighbors){
                    if(set.contains(neighbor)) continue;
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
}
