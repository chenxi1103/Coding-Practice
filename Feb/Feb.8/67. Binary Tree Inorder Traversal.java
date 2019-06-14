//个人认为树的中序遍历的travesal法有点难理解，需要多做几遍
public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        while(root != null) {
            stack.add(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            TreeNode currNode = stack.peek();
            list.add(currNode.val);
            if(currNode.right == null) {
                TreeNode node = stack.pop();
                //这一步至关重要，中根遍历有一个左中右的顺序，当右被遍历完以后，要再次回到中（有点像回溯），然后从中回到中的父节点，
                //再进行下一步的遍历，这个顺序导致了中节点会被遍历两次，所以我们一开始不能直接pop，要peek，第一次遍历到中的时候，
                //只把val加进list里，第二次遍历到中的时候，直接pop，while循环一直pop到从没遍历过的中的父节点
                while(!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                TreeNode node = currNode.right;
                while(node != null) {
                    stack.add(node);
                    node = node.left;
                }
            }
        }
        return list;
    }
}
