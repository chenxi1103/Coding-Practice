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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     * 第一种方法：非递归方法
     * 2018-10-26 1：40
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return result;
        //First, push all the left child whose ansestor is root into stack
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            //pop the last node in the stack
            TreeNode temp = stack.pop();
            //Add value into ArrayList
            result.add(temp.val);
            //Check the right child of this node
            if(temp.right!=null){
                TreeNode temp2 = temp.right;
                while(temp2!=null){
                    stack.push(temp2);
                    //push all the left child of this right node into stack
                    temp2 = temp2.left;
                }
            }
        }
        return result;
    }

public class Solution {
      /**
       * @param root: A Tree
       * @return: Inorder in ArrayList which contains node values.
       * 第二种方法：正常递归方法
       * 2018-10-26 1：45
       */
    public List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        if(root == null) return result;
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }
}
}
