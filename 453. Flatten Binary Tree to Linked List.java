// 方法1，DFS，需要O(n)extra space
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        
        if (root == null) {
            return;
        }   
        Stack<TreeNode> stack = new Stack(); //用栈实现DFS
        stack.push(root);
        
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);      //先右后左
            }
            //连接节点
            node.left = null;           
            if (stack.empty()) {
                node.right = null;
            } else {
                node.right = stack.peek();//由于之前先压右节点后压左节点的操作，只要将当前节点的right指向stack.peek()就行了
            }
        }
    }
} 


//方法2，递归，不耗费额外空间：
//思路：对于  root   需要的操作为：1.root.right指向left的起始 2.left的末端（未知）指向right 
//            / \         
//         left  right
//      因此，需要一个递归函数，返回flatten之后的末端节点
public class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    public TreeNode helper(TreeNode root) { 
        if (root == null) {
            return null;
        }
        
        TreeNode left = helper(root.left);      //返回链化后左子树末端节点
        TreeNode right = helper(root.right);    //返回右子树末端节点
        
        if (left != null) {
            left.right = root.right;            //left的末端指向right
            root.right = root.left;             //root.right指向left的起始
            root.left = null;                   //root.left清空
        }//只要左子树非空，就执行以上操作 
        
        if (right != null) {    //只要右子树末节点非空，那它一定是函数要返回的末节点
            return right;
        }
        if (left != null) {     //到了这一步，还剩左侧末节点为null和!null两种情况(右侧为null)
            return left;
        }
        return root;
    }
    
}
