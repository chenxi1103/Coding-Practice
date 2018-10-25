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

//Traverse的方法，很好理解很好想，就是会忘记把right拿出来比较讨厌
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public TreeNode node = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(node != null){
            node.left = null;
            node.right = root;
        }
        node = root;
        //重点：right一定要提前拿出来，不拿出来root.right就要连上left里的点就不是原来的那个right了
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}

//用stack实现的Non-Recursion的方法，比较好理解，关键在于node.right赋值时不要把stack里的东西拿出来，查看一下（peek）就可以了
public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            
            node.left = null;
            if(stack.empty()){
                node.right = null;
            }else{
                node.right = stack.peek();
            }
        }
        
    }
