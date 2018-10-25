/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    //UndirectedGraphNode Questions: hashmap and queue!!!No queue.size()!!!
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if(s.label == t.label) return 0;
        HashMap<UndirectedGraphNode,Integer> map = new HashMap<UndirectedGraphNode,Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(s);
        map.put(s,0);
        while(!queue.isEmpty()){
            UndirectedGraphNode node = queue.poll();
            int steps = map.get(node);
            for(UndirectedGraphNode neighbor: node.neighbors){
                if(neighbor.label == t.label) return steps+1;
                if(map.containsKey(neighbor)){
                    continue;
                }else{
                    map.put(neighbor,steps+1);
                    queue.offer(neighbor);
                }
            }
        }
        return -1;
    }
}
