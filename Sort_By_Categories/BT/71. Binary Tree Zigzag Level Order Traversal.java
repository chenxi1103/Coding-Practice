public class Solution {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i<size; ++i){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            if(!leftToRight){
                Collections.reverse(temp);
            }
            leftToRight = !leftToRight;
            result.add(temp);
        }
        return result;
    }
}
