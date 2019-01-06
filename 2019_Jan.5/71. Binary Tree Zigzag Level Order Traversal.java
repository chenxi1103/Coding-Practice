/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
//reverse list的方法：（不太好）
public class Solution {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode currNode = queue.poll();
                level.add(currNode.val);
                if(currNode.left!=null) queue.offer(currNode.left);
                if(currNode.right!=null) queue.offer(currNode.right);
            }
            if(count%2 == 1){
                Collections.reverse(level);
            }
            count++;
            result.add(level);
        }
        return result;
    }
}


/////////////////////////////用stack，直接用zigzay的方式遍历tree//////////////////////////
public class Solution {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> curr_stack = new Stack<>();
        Stack<TreeNode> next_stack = new Stack<>();
        int count = 0;
        curr_stack.push(root);
        while(!curr_stack.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            while(!curr_stack.isEmpty()){
                TreeNode curr_node = curr_stack.pop();
                level.add(curr_node.val);
                if(count % 2 == 1){
                    if(curr_node.right != null) next_stack.push(curr_node.right);
                    if(curr_node.left != null) next_stack.push(curr_node.left);
                }else{
                    if(curr_node.left != null) next_stack.push(curr_node.left);
                    if(curr_node.right != null) next_stack.push(curr_node.right);
                }
            }
            count++;
            result.add(level);
            curr_stack = next_stack;
            next_stack = new Stack<>();
        }
        return result;
    }
}
