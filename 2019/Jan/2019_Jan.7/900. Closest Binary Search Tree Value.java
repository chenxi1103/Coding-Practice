public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        double curr_min = Double.MAX_VALUE;
        int result = 0;
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(Math.abs(node.val - target) < curr_min){
                 curr_min = Math.abs(node.val - target);
                 result = node.val;
            }else return result;
            if(node.right == null){
                node = stack.pop();
                while(!stack.isEmpty() && stack.peek().right == node){
                    node = stack.pop();
                }
            }else{
                node = node.right;
                while(node!=null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return result;
    }
}
