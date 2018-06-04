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
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode,Integer> indegree = new HashMap<DirectedGraphNode,Integer>();
        //Count the indegree for each node
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(indegree.containsKey(neighbor)){
                    indegree.put(neighbor,indegree.get(neighbor)+1);
                }else{
                    indegree.put(neighbor,1);
                }
            }
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        //put the nodes whose indegree is 0 into the queue
        for(DirectedGraphNode node : graph){
            if(!indegree.containsKey(node)){
                result.add(node);
                queue.offer(node);
            }
        }
        
        while(!queue.isEmpty()){
            DirectedGraphNode currNode = queue.poll();
            //when pull out the node, for neighbors, indegree minus 1
            for(DirectedGraphNode neighbor : currNode.neighbors){
                indegree.put(neighbor,indegree.get(neighbor)-1);
                //if the indegree is 0, put into the queue
                if(indegree.get(neighbor) == 0){
                    result.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }
}
