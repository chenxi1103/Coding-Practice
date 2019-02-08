public class Solution {
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode prev = null;
        while(!stack.isEmpty()) {
            TreeNode currNode = stack.peek();
            if(prev == null || prev.left == currNode || prev.right == currNode) {
                if(currNode.left != null) {
                    stack.add(currNode.left);
                }
                //用else if，不是if，每次只做一次操作
                else if(currNode.right != null) {
                    stack.add(currNode.right);
                }
            }
            else if(currNode.left == prev) {
                if(currNode.right != null) {
                    stack.add(currNode.right);
                }
            } else {
                list.add(currNode.val);
                stack.pop();
            }
            prev = currNode;
        }
        return list;
    }
}
