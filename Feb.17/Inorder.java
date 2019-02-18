class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return list;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        getLeft(stack, root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if(curr.right != null) {
                curr = curr.right;
                getLeft(stack, curr);
            }
        }
        return list;
    }
    private void getLeft(Stack<TreeNode> stack, TreeNode node) {
        while(node != null) {
            stack.add(node);
            node = node.left;
        }
        return;
    }
}
