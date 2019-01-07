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
/*
 *复习一下二叉树的遍历方法，记得总结递归和非递归的方法！
 *
 */
 // recursion的写法：
public class Solution {
    public List<Integer> result = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return result;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }
}

//非recursion写法1:
//因为如果是非recursion，只有先序遍历是好写的，中序和后序都需要再写一个hashmap来记录已经
//访问过的结点，不太好写，这里是用了后序遍历就是先序遍历的reverse（有点犯规）的方法写出来的
//后续总结一下中序和后续非递归的写法。
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return result;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp!=null){
                result.add(temp.val);
                stack.push(temp.left);
                stack.push(temp.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
