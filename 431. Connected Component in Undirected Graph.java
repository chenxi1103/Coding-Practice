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
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        for(UndirectedGraphNode node : nodes){
            //想要略过已经visited的点，不要老想着把点从list里remove，慢，通不过
            //要学会用一个set存visited点，如果里面包含了，不访问就是了
            if(!visited.contains(node)){
                result.add(BFS(node,visited,nodes));
            }
        }
        return result;
    }
    private ArrayList<Integer> BFS(UndirectedGraphNode node, HashSet<UndirectedGraphNode> visited, List<UndirectedGraphNode> nodes){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        visited.add(node);
        result.add(node.label);
        while(!queue.isEmpty()){
            UndirectedGraphNode currNode = queue.poll();
            for(UndirectedGraphNode neighbor : currNode.neighbors){
                if(visited.contains(neighbor)) continue;
                else{
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    result.add(neighbor.label);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
