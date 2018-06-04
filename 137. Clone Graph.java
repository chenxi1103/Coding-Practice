/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        
        //define a function to get all the node (without their relationship)
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        //Now store the relationship among all the nodes and values into "mapping"
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
       
        //Go through all the nodes in the map and get its label(value?)
        for(UndirectedGraphNode n: nodes){
            mapping.put(n,new UndirectedGraphNode(n.label));
        }
        
        for(UndirectedGraphNode n: nodes){
            UndirectedGraphNode newNode = mapping.get(n);//copy the node to newNode
            for(UndirectedGraphNode neighbors : n.neighbors){
                UndirectedGraphNode newNeighbor = mapping.get(neighbors);
                //add the neighbors to the newNode's neighbors
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        //queue and set come up together
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        
        //queue and set come up together
        //one offer, the other add
        queue.offer(node);
        set.add(node);
        
        //BFS
        while(!queue.isEmpty()){
            //pull the first node out
            UndirectedGraphNode currNode = queue.poll();
            //get its neighbors out and store in the set
            for(UndirectedGraphNode neighbors: currNode.neighbors){
                //HashSet can only store the unique element
                if(!set.contains(neighbors)){
                    //queue and set always come together!
                    set.add(neighbors);
                    queue.offer(neighbors);
                }
            }
        }
        //ArrayList<>(set) represents that copy the elements from the set into a new ArrayList
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
