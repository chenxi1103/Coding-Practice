public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        HashMap<DirectedGraphNode, Integer> degrees = new HashMap<>();

        for(int i = 0; i<graph.size(); i++){
            degrees.put(graph.get(i), 0);
        }

        for(int i = 0; i<graph.size(); i++){
            for(DirectedGraphNode neighbor : graph.get(i).neighbors){
                degrees.put(neighbor, degrees.get(neighbor) + 1);
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode key : degrees.keySet()){
            if(degrees.get(key) == 0){
                queue.offer(key);
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                DirectedGraphNode node = queue.poll();
                result.add(node);
                for(int j = 0; j<node.neighbors.size(); j++){
                    DirectedGraphNode neighbor = node.neighbors.get(j);
                    degrees.put(neighbor, degrees.get(neighbor) - 1);
                    if(degrees.get(neighbor) == 0){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return result;
    }
}
