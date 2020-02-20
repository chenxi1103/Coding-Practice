//递归方法
public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
//非递归方法
//所有的bst非递归都记住一个原则：如果当前点存在右子树，那么就是右子树中“一路向西”最左边的那个点； 如果当前点不存在右子树，则是走到当前点的路径中，第一个左拐的点

public class Solution {
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode curr_node = stack.peek();
            TreeNode node = curr_node;
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
            list.add(curr_node.val);
        }
        return list;
    }
}
