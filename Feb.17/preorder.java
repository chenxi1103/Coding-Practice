class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}
//记住一个重要的教训！只有层级遍历才会用queue，前中后序的非递归遍历都是stack！！！
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if(curr != null) {
                list.add(curr.val);
                stack.add(curr.right);
                stack.add(curr.left);
            }
        }
        return list;
    }
}
