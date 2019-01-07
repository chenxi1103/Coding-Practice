//拓扑排序，重点在于统计入度，把没有入度的点放进queue，每循环一个点就减一个入度，知道等于0）
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if(graph == null || graph.size() == 0) return result;
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(map.containsKey(neighbor)){
                    map.put(neighbor, map.get(neighbor) + 1);
                }else{
                    map.put(neighbor, 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node : graph){
            if(!map.containsKey(node)){
                queue.offer(node);
                result.add(node);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                DirectedGraphNode node = queue.poll();
                for(DirectedGraphNode neighbor : node.neighbors){
                    map.put(neighbor, map.get(neighbor) - 1);
                    if(map.get(neighbor) == 0) {
                        queue.offer(neighbor);
                        result.add(neighbor);
                    }
                }
            }
        }
        return result;
    }
}
