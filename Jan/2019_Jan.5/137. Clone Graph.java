//图的遍历，第一步找到所有不重复的点，第二循环这些点，新建一个相同label的点并循环加入每个点的neigbors
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null) return node;
        HashSet<UndirectedGraphNode> set = getAllNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for(UndirectedGraphNode Node : set){
            map.put(Node, new UndirectedGraphNode(Node.label));
        }
        for(UndirectedGraphNode key : set){
            UndirectedGraphNode currNode = map.get(key);
            for(UndirectedGraphNode neighbor : key.neighbors){
              //这里是关键，不要直接把neighbor放进currNode的neighbors里，因为这个neighbor不是一个单一的无向点，而是包含了邻居关系的无项点。
              //要把新创建的存在map里的，只有label值的无项点存在neighbor里
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                currNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);

    }
    private HashSet<UndirectedGraphNode> getAllNodes(UndirectedGraphNode Node){
        HashSet<UndirectedGraphNode> result = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(Node);
        result.add(Node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                UndirectedGraphNode currNode = queue.poll();
                for(UndirectedGraphNode neighbor : currNode.neighbors){
                    if(!result.contains(neighbor)){
                        result.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return result;
    }
}
