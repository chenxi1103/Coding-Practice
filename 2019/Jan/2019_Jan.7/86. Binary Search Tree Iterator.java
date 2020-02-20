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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */

////////////////////////////自己写的超笨方法，能过，但是基本上是全网最慢了///////////////////
public class BSTIterator {
    /*
    * @param root: The root of binary tree.
    */
    public int count;
    public ArrayList<TreeNode> list;
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        count = 0;
        list = new ArrayList<>();
        helper(root, list);
    }
    private void helper(TreeNode root, ArrayList<TreeNode> list){
        if(root == null) return;
        helper(root.left, list);
        list.add(root);
        helper(root.right, list);
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return count <= list.size() - 1;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode result = list.get(count);
        count++;
        return result;
    }
}

///////////////////////理解全文并背诵////////////////////////////////
public class BSTIterator {
    /*
    * @param root: The root of binary tree.
    */
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode currNode = stack.peek();
        TreeNode node = currNode;
        if(node.right == null){
            node = stack.pop();
            while(!stack.isEmpty() && stack.peek().right == node){
                node = stack.pop();
            }
        }else{
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return currNode;
    }
}
