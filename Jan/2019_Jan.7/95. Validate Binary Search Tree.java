//遇到二分搜索树的问题，基本上都是中序遍历，因为二分搜索树的特点就是，先序遍历是从小到大的！通过这个性质来判断是不是二分搜索树
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

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public int lastVal = Integer.MIN_VALUE;
    public boolean isFirstNode = true;
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(!isFirstNode && lastVal >= root.val) return false;
        isFirstNode = false;
        lastVal = root.val;
        if(!isValidBST(root.right)) return false;
        return true;
    }
}
/////////////////////非递归的方法/////////////////////
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        TreeNode lastnode = null;
        while(!stack.isEmpty()){
            TreeNode curr_node = stack.peek();
            if(lastnode != null && curr_node.val <= lastnode.val) return false;
            lastnode = curr_node;
            if(curr_node.right == null){
                curr_node = stack.pop();
                while(!stack.isEmpty() && stack.peek().right == curr_node){
                    curr_node = stack.pop();
                }
            }else{
                curr_node = curr_node.right;
                while(curr_node != null){
                    stack.push(curr_node);
                    curr_node = curr_node.left;
                }
            }
        }
        return true;
    }
}
